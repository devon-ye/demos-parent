package org.devon.concurrency.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/11/19.
 */
public class StopThread {
    private static boolean stopRequested;

    private static synchronized void requetStop(){
        stopRequested = true;
    }

    private static synchronized boolean stopRequested(){
        return  stopRequested;
    }
    private ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested()){
                    i++;
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requetStop();

    }



   /* private static boolean volatile stopRequested;
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested){
                    i++;
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested=false;

    }*/






}
