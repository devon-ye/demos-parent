package org.devon.middleware.hbase;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hbase.async.KeyValue;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @author dewen.ye
 * @date 2019/8/14 16:49
 * @since
 */
public abstract class AbstractHBaseDao<T> extends RecursiveTask implements Dao {

	@Resource
	private HBaseSearch search;

	@Resource
	private MetricRegistry metricRegistry;

	protected static final ObjectMapper MAPPER = new ObjectMapper();

	protected static final String SPLIT_SYMBOL = "#";


	public List<KeyValue> getRequest(String table, String rowKey, String family) {
		return search.getRequest(table, rowKey, family);
	}

	public List<KeyValue> getRequest(String table, String rowKey, String family, String qualifier) {
		return search.getRequest(table, rowKey, family, qualifier);
	}

	public ArrayList<ArrayList<KeyValue>> getBatchRequest(String table, List<String> rowKeys, String family) {
		return search.getBatchRequest(table, rowKeys, family);
	}

	public ArrayList<ArrayList<KeyValue>> getBatchRequest(String table, List<String> rowKeys, String family, String qualifier) {
		return search.getBatchRequest(table, rowKeys, family, qualifier);
	}

	public ArrayList<ArrayList<KeyValue>> scanRequest(ScanQueryParam scanQueryParam) {
		return search.scanRequest(scanQueryParam);
	}

	public ArrayList<ArrayList<ArrayList<KeyValue>>> scanBatchRequest(ScanQueryParam scanQueryParam) {
		return search.scanBatchRequest(scanQueryParam);
	}

	public ArrayList<ArrayList<ArrayList<KeyValue>>> asyncScanBatchRequest(ScanQueryParam scanQueryParam) {
		return search.asyncScanBatchRequest(scanQueryParam);
	}



	public ArrayList<ArrayList<ArrayList<KeyValue>>> parallelScanBatchRequest(ScanQueryParam scanQueryParam) {
		return search.asyncParallelScanRequest(scanQueryParam);
	}

	public abstract T transListKeyValueToObject(List<KeyValue> keyValueList);

	protected List<T> transListListKeyValueToObject(ArrayList<ArrayList<KeyValue>> listListList) {
		List<T> result = null;
		if (listListList == null) {
			return new ArrayList<>(0);
		} else {
			result = new ArrayList<>(listListList.size() * 2);
		}
		Timer.Context timer = metricRegistry.timer("transListListKeyValueToObject.timer").time();
		try {
			for (ArrayList<KeyValue> keyValueArrayList : listListList) {
				if (keyValueArrayList == null) continue;
				T row = transListKeyValueToObject(keyValueArrayList);
				result.add(row);
			}
		} finally {
			timer.stop();
		}
		return result;
	}

	protected List<T> transListListListKeyValueToObject(ArrayList<ArrayList<ArrayList<KeyValue>>> keyValueListListList) {
		List<T> result = null;
		if (keyValueListListList == null) {
			return new ArrayList<>(0);
		} else {
			result = new ArrayList<>(keyValueListListList.size() * 2);
		}
		Timer.Context context = metricRegistry.timer("transListListListKeyValueToObject.timer").time();
		try {
			for (ArrayList<ArrayList<KeyValue>> keyValueListList : keyValueListListList) {
				if (keyValueListList == null) continue;
				for (ArrayList<KeyValue> keyValueArrayList : keyValueListList) {
					T row = transListKeyValueToObject(keyValueArrayList);
					result.add(row);
				}
			}
		} finally {
			context.stop();
		}
		return result;
	}


}
