package org.devon.middleware.hbase;

import org.hbase.async.KeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dewen.ye
 * @date 2019/10/11 12:19
 * @since
 */
public interface HBaseSearch {

    List<KeyValue> getRequest(String table, String rowKey, String family);

    List<KeyValue> getRequest(String table, String rowKey, String family, String qualifier);

    ArrayList<ArrayList<KeyValue>> getBatchRequest(String table, List<String> rowKey, String family);

    ArrayList<ArrayList<KeyValue>> getBatchRequest(String table, List<String> rowKey, String family, String qualifier);

    ArrayList<ArrayList<KeyValue>> scanRequest(ScanQueryParam scanQueryParam);

    ArrayList<ArrayList<ArrayList<KeyValue>>> scanBatchRequest(ScanQueryParam param);

    ArrayList<ArrayList<ArrayList<KeyValue>>> asyncScanBatchRequest(ScanQueryParam param);

	ArrayList<ArrayList<ArrayList<KeyValue>>> asyncParallelScanRequest(ScanQueryParam param);



}
