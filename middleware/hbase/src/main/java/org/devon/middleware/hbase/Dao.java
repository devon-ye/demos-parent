package org.devon.middleware.hbase;


import java.util.List;

/**
 * @author dewen.ye
 * @date 2019/8/14 16:48
 * @since
 */
public interface Dao<T> {

    T getRequest(String key);

    List<T> getBatchRequest(List<String> keys);

    List<T> scanRequest(KeyRangeTuple keyRangeTuple);

    List<T> scanBatchRequest(List<KeyRangeTuple> keyRangeTuples);

    List<T> asyncScanBatchRequest(List<KeyRangeTuple> keyRangeTuples);

    List<T>  parallelScanBatchRequest(List<KeyRangeTuple> keyRangeTuples);




}
