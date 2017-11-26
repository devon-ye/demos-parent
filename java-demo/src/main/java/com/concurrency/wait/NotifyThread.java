package com.concurrency.wait;

/**
 * Created by lenovo on 2017/10/26.
 */
public class NotifyThread extends  Thread {

    private Object lock;
    public NotifyThread(Object lock){
        this.lock = lock;
    }


    @Override
    public void run() {
        try {
            synchronized(lock){
                System.out.println("string  notify time=" +System.currentTimeMillis());
                lock.notify();
                System.out.println("ending  notify time=" +System.currentTimeMillis());
            }
        }catch (Exception e){

        }
    }

}
