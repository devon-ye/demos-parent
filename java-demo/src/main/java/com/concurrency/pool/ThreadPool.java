package com.concurrency.pool;

/**
 * Created by lenovo on 2017/10/15.
 */
public interface ThreadPool {

    void shutDown();

    void addWorkers(int jobSize);

    void removeWorker(int removeSize);

    int getJobSize();
}
