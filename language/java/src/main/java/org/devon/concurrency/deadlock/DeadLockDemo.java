package org.devon.concurrency.deadlock;

/**
 * Created by lenovo on 2017/10/3.
 */
public class DeadLockDemo {
    private  static String A="A";
    private  static String B="B";


    public void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        A.wait(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                synchronized (B){
                    System.out.println("1");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    System.out.println("2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
