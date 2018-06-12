package com.concurrency.pool;



import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lenovo on 2017/10/15.
 */
public class DefaultThreadPool {
    private static final int MAX_WORKERS_SIZE = 10;
    private static final int MIN_WORKERS_SIZE =1;
    private static final int DEFAULT_WORKERS_SIZE = 5;

    private LinkedList<Job> jobs = new  LinkedList<Job>();
    private List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    private int workerSize = DEFAULT_WORKERS_SIZE;

    private AtomicLong threadId = new AtomicLong();


    public DefaultThreadPool() {
        initWokers(DEFAULT_WORKERS_SIZE);
    }

    public DefaultThreadPool(int workerSize) {
        if(workerSize > MAX_WORKERS_SIZE) {
            workerSize = MAX_WORKERS_SIZE;
        }
        if(workerSize < MIN_WORKERS_SIZE) {
            throw new IllegalArgumentException();
        }

        initWokers(workerSize);
    }

    public void excute(Job job){
        if(job != null) {
            jobs.addLast(job);
            jobs.notify();
        }
    }


    public void shutDown() {
        for(Worker worker:workers) {
            worker.shutDown();
        }
    }


    public void addWorkers(int jobSize) {

        synchronized (jobs){
            if(jobSize  + this.workerSize > MAX_WORKERS_SIZE){
                jobSize = MAX_WORKERS_SIZE - this.workerSize;
            }
            initWokers(jobSize);
            this.workerSize+=jobSize;
        }

    }


    public void removeWorker(int removeSize) {
        synchronized (jobs) {
            if(removeSize > this.workerSize) {
                throw new IllegalArgumentException("removeSize gt currentWorkerSize!");
            }
            int count =0;
            while(count < removeSize) {
                Worker worker = workers.get(count);
                if(workers.remove(worker)) {
                    worker.shutDown();
                    count ++;
                }

            }
            this.workerSize-=count;
        }
    }



    public int getJobSize() {
        return  jobs.size();
    }

    private void initWokers(int workerSize){
        for(int i = 0 ; i < workerSize; i++) {
            Worker worker = new Worker();
            Thread thread = new Thread(worker,"ThhreadPool-Worker-" + threadId.incrementAndGet());
            thread.start();
        }
    }


}
