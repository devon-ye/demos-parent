package org.devon.middleware.hbase;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.google.common.collect.Lists;
import com.stumbleupon.async.Deferred;
import org.hbase.async.GetRequest;
import org.hbase.async.HBaseClient;
import org.hbase.async.KeyValue;
import org.hbase.async.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


/**
 * @author dewen.ye
 * @date 2019/10/11 12:20
 * @since
 */
public class HBaseSearchImpl extends RecursiveTask<ArrayList<ArrayList<ArrayList<KeyValue>>>> implements HBaseSearch {
	private static final Logger LOG = LoggerFactory.getLogger(HBaseSearchImpl.class);

	private MetricRegistry metricRegistry;
	private Timer timer = metricRegistry.timer("hbase.read.time");

	private HBaseClient hbaseClient;

	private ForkJoinPool forkJoinPool;

	private ScanQueryParam scanQueryParam;

	private static final Integer BATCH_SIZE = 100;

	@Override
	public List<KeyValue> getRequest(String table, String rowKey, String family) {
		return getRequest(table, rowKey, family, null);
	}

	@Override
	public List<KeyValue> getRequest(String table, String rowKey, String family, String qualifier) {
		Timer.Context context = timer.time();
		GetRequest request = this.getGetRequest(table, family, qualifier, rowKey);

		try {
			return hbaseClient.get(request).join();
		} catch (Exception e) {
			LOG.error("hbase getRequest fail! ", e);
		} finally {
			context.stop();
		}
		return null;
	}


	@Override
	public ArrayList<ArrayList<KeyValue>> getBatchRequest(String table, List<String> rowKeys, String family) {
		return getBatchRequest(table, rowKeys, family, null);
	}

	@Override
	public ArrayList<ArrayList<KeyValue>> getBatchRequest(String table, List<String> rowKeys, String family,
														  String qualifier) {
		Timer.Context context = timer.time();

		Collection<Deferred<ArrayList<KeyValue>>> deferredList = new ArrayList<>(rowKeys.size());
		for (String rowKey : rowKeys) {
			GetRequest request = getGetRequest(table, family, qualifier, rowKey);
			deferredList.add(hbaseClient.get(request));
		}

		ArrayList<ArrayList<KeyValue>> keyValues = null;
		try {
			keyValues = Deferred.group(deferredList).join();
		} catch (Exception e) {
			LOG.error("hbase getBatchRequest fail! ", e);
		} finally {
			context.stop();
		}
		return keyValues;
	}

	private GetRequest getGetRequest(String table, String family, String qualifier, String rowKey) {
		GetRequest request = null;
		if (qualifier == null) {
			request = new GetRequest(table, rowKey, family);
		} else {
			request = new GetRequest(table, rowKey, family, qualifier);
		}
		return request;
	}

	@Override
	public ArrayList<ArrayList<KeyValue>> scanRequest(ScanQueryParam scanQueryParam) {
		Timer.Context context = timer.time();

		Scanner scanner = hbaseClient.newScanner(scanQueryParam.getTable());
		setFamiliesQualifiers(scanQueryParam, scanner);
		final KeyRangeTuple keyRangeTuple = scanQueryParam.getKeyRangeTuples().get(0);
		scanner.setStartKey(keyRangeTuple.getStartKey());
		scanner.setStopKey(keyRangeTuple.getStopKey());
		scanner.setMaxNumRows(keyRangeTuple.getRowSize());
		ArrayList<ArrayList<KeyValue>> keyValues = null;
		try {
			keyValues = scanner.nextRows().join();
		} catch (Exception e) {
			LOG.error("hbase scanRequest fail! ", e);
		} finally {
			context.stop();
			scanner.close();
		}
		return keyValues;
	}


	@Override
	public ArrayList<ArrayList<ArrayList<KeyValue>>> scanBatchRequest(ScanQueryParam param) {
		Timer.Context context = timer.time();

		Collection<Deferred<ArrayList<ArrayList<KeyValue>>>> deferreds = new ArrayList<>();
		List<KeyRangeTuple> keyRangeTuples = param.getKeyRangeTuples();
		for (KeyRangeTuple keyRangeTuple : keyRangeTuples) {
			Scanner scanner = hbaseClient.newScanner(param.getTable());
			scanner.setStartKey(keyRangeTuple.getStartKey());
			scanner.setStopKey(keyRangeTuple.getStopKey());
			String keyRegexp = keyRangeTuple.getStartKey().substring(0, keyRangeTuple.getStartKey().length() - 10);
			scanner.setKeyRegexp(keyRegexp);
			scanner.setMaxNumBytes(10000000);
			scanner.setMaxNumKeyValues(1000000);
			setFamiliesQualifiers(param, scanner);
			scanner.setMaxNumRows(keyRangeTuple.getRowSize());
			deferreds.add(scanner.nextRows());
		}
		ArrayList<ArrayList<ArrayList<KeyValue>>> keyValues = null;
		try {
			keyValues = Deferred.group(deferreds).joinUninterruptibly();
		} catch (Exception e) {
			LOG.error("hbase scanRequest fail! ", e);
		} finally {
			context.stop();
		}
		return keyValues;
	}

	@Override
	public ArrayList<ArrayList<ArrayList<KeyValue>>> asyncScanBatchRequest(ScanQueryParam param) {
		Timer.Context context = timer.time();

		ArrayList<ArrayList<ArrayList<KeyValue>>> result = new ArrayList<>();
		List<KeyRangeTuple> keyRangeTuples = param.getKeyRangeTuples();
		CountDownLatch downLatch = new CountDownLatch(keyRangeTuples.size());
		for (KeyRangeTuple keyRangeTuple : keyRangeTuples) {
			Scanner scanner = hbaseClient.newScanner(param.getTable());
			scanner.setStartKey(keyRangeTuple.getStartKey());
			scanner.setStopKey(keyRangeTuple.getStopKey());
			String keyRegexp = keyRangeTuple.getStartKey().substring(0, keyRangeTuple.getStartKey().length() - 10);
			scanner.setKeyRegexp(keyRegexp);
			scanner.setMaxNumBytes(10000000);
			scanner.setMaxNumKeyValues(1000000);
			setFamiliesQualifiers(param, scanner);
			scanner.setMaxNumRows(keyRangeTuple.getRowSize());
			processDeferred(scanner.nextRows(), result, downLatch);
		}
		try {
			downLatch.await();
		} catch (InterruptedException e) {
			LOG.error("hbase ");
		} finally {
			context.stop();
		}
		return result;
	}

	@Override
	public ArrayList<ArrayList<ArrayList<KeyValue>>> asyncParallelScanRequest(ScanQueryParam param) {
		HBaseSearchImpl hBaseSearch = new HBaseSearchImpl();
		hBaseSearch.setScanQueryParam(param);
		hBaseSearch.setHbaseClient(this.hbaseClient);
		return forkJoinPool.invoke(hBaseSearch);
	}

	private void setFamiliesQualifiers(ScanQueryParam scanQueryParam, Scanner scanner) {
		int familySize = scanQueryParam.getFamilys().length;
		if (familySize == 1) {
			scanner.setFamilies(scanQueryParam.getFamilys());
			scanner.setQualifiers(scanQueryParam.toQualifiers());
		} else if (familySize > 1) {
			byte[][] familyBytes = new byte[familySize][];
			String[] familyArray = scanQueryParam.getFamilys();
			byte[][][] qualifiers = new byte[2][][];
			for (int i = 0; i < familyArray.length; i++) {
				familyBytes[i] = familyArray[i].getBytes();
				qualifiers[i] = scanQueryParam.toQualifiers();
			}
			scanner.setFamilies(familyBytes, qualifiers);
		}
	}

	protected void processDeferred(Deferred deferred, List<ArrayList<ArrayList<KeyValue>>> resultList, CountDownLatch downLatch) {
		CompletableFuture.supplyAsync(() -> deferred).thenRunAsync(() -> {
			try {
				ArrayList<ArrayList<KeyValue>> result = (ArrayList<ArrayList<KeyValue>>) deferred.joinUninterruptibly();
				if (result != null && !result.isEmpty()) {
					resultList.add(result);
				}
				downLatch.countDown();
			} catch (Exception e) {
				downLatch.countDown();
				LOG.error("processDeferred fail! ", e);
			}
		});
	}

	@Override
	protected ArrayList<ArrayList<ArrayList<KeyValue>>> compute() {
		List<KeyRangeTuple> keyRangeTupleList = this.scanQueryParam.getKeyRangeTuples();
		if (keyRangeTupleList == null || keyRangeTupleList.size() <= 0) {
			return new ArrayList<>(0);
		}
		if (keyRangeTupleList.size() < BATCH_SIZE) {
			Collection<Deferred<ArrayList<ArrayList<KeyValue>>>> deferredList = new ArrayList<>(keyRangeTupleList.size());
			for (KeyRangeTuple keyRangeTuple : keyRangeTupleList) {
				if (keyRangeTuple == null) continue;
				final Scanner scanner = this.hbaseClient.newScanner(scanQueryParam.getTable());
				scanner.setStartKey(keyRangeTuple.getStartKey());
				scanner.setStopKey(keyRangeTuple.getStopKey());
				setFamiliesQualifiers(scanQueryParam, scanner);
				scanner.setMaxNumRows(keyRangeTuple.getRowSize());
				deferredList.add(scanner.nextRows());
			}
			try {
				return Deferred.group(deferredList).joinUninterruptibly();
			} catch (Exception e) {
				return null;
			}
		} else {
			List<List<KeyRangeTuple>> keyRangeTuples2 = Lists.partition(keyRangeTupleList, keyRangeTupleList.size() / 2);
			HBaseSearchImpl left = new HBaseSearchImpl();
			HBaseSearchImpl right = new HBaseSearchImpl();
			ScanQueryParam leftParams = new ScanQueryParam(scanQueryParam.getTable(), keyRangeTuples2.get(0), scanQueryParam.getFamilys(), scanQueryParam.getQualifierList());
			ScanQueryParam rightParams = new ScanQueryParam(scanQueryParam.getTable(), keyRangeTuples2.get(1), scanQueryParam.getFamilys(), scanQueryParam.getQualifierList());

			left.setScanQueryParam(leftParams);
			left.setHbaseClient(this.getHbaseClient());
			right.setScanQueryParam(rightParams);
			right.setHbaseClient(this.getHbaseClient());
			left.fork();
			right.fork();

			ArrayList<ArrayList<ArrayList<KeyValue>>> leftResult = left.join();
			ArrayList<ArrayList<ArrayList<KeyValue>>> rightResult = right.join();

			if (leftResult != null && rightResult != null) {
				leftResult.addAll(rightResult);
				return leftResult;
			} else if (leftResult == null && rightResult != null) {
				return rightResult;
			} else if (leftResult != null && rightResult == null) {
				return leftResult;
			} else {
				return new ArrayList<>();
			}
		}
	}


	public void setScanQueryParam(ScanQueryParam scanQueryParam) {
		this.scanQueryParam = scanQueryParam;
	}

	public ScanQueryParam getScanQueryParam() {
		return scanQueryParam;
	}

	public void setHbaseClient(HBaseClient hbaseClient) {
		this.hbaseClient = hbaseClient;
	}

	public HBaseClient getHbaseClient() {
		return hbaseClient;
	}
}
