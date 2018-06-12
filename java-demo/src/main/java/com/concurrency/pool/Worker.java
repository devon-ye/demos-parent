package com.concurrency.pool;

import java.util.LinkedList;

/**
 * Created by lenovo on 2017/10/15.
 */
public class Worker implements Runnable {

    private volatile boolean running  = false;

    private LinkedList<Job> jobs;

    public Worker() {

    }

    public Worker(LinkedList<Job> jobs) {
        this.jobs = jobs;
    }



    @Override
    public void run() {
        running = true;
        while (running) {
            Job job = null;
            synchronized (jobs) {
                while (jobs.isEmpty()){
                    try {
                        jobs.wait();
                    }catch (Exception e){
                        //感知外部对WorkerTHread的终端操作，返回
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                job = jobs.removeFirst();
            }
            if(job != null) {
                job.run();
            }

        }

    }

    public void shutDown() {
        running = false;
    }
}
