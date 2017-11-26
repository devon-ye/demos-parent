package com.concurrency.lock.clazz;

/**
 * Created by lenovo on 2017/10/12.
 */
public class Service {

     public  static synchronized void printA() {
        try {
            System.out.println("thread name is:" + Thread.currentThread().getName() + ", currentTimeMS:" + System.currentTimeMillis() + ",into printA()");
            Thread.sleep(5000);

            System.out.println("thread name is:" + Thread.currentThread().getName() + ", currentTimeMS:" + System.currentTimeMillis() + ",outto printA()");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static void printB() {
        try {
            System.out.println("thread name is:" + Thread.currentThread().getName() + ", currentTimeMS:" + System.currentTimeMillis() + ",into printB()");
            Thread.sleep(5000);

            System.out.println("thread name is:" + Thread.currentThread().getName() + ", currentTimeMS:" + System.currentTimeMillis() + ",outto printB()");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
