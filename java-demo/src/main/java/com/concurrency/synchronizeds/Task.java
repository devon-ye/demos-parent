package com.concurrency.synchronizeds;

/**
 * Created by lenovo on 2017/10/11.
 */
public class Task {

    public void doLongTimeTask() {
        for(int i = 0 ; i <  100 ; i ++) {
            System.out.println("###asynchronized threadName=" +Thread.currentThread().getName() + ", i=" +(i+1));
        }

        System.out.println("");

        synchronized(this){
            for(int i = 0 ; i <  100 ; i ++) {
                System.out.println("synchronized threadName=" +Thread.currentThread().getName() + ", i=" +(i+1));
            }
        }

    }
}
