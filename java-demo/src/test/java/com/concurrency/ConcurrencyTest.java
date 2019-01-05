package com.concurrency;

/**
 * Created by lenovo on 2017/10/2.
 */
public class ConcurrencyTest {
    private static final long count = 100L;

    public static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread thread  = new Thread(new Runnable(){


            public void run() {
                int a = 0;
                for(long  i = 0; i < count; i++) {
                    a += 5;

                }
            }
        });
        thread.start();
        int b = 0;
        for(long i=0;i<count;i++) {
            b--;
        }
        long time = System.currentTimeMillis()-start;
        thread.join();

        System.out.println("concurrency: " +time +"ms, b=" +b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for(long  i = 0; i < count; i++) {
            a += 5;

        }
        int b = 0;
        for(long i=0;i<count;i++) {
            b--;
        }
        long time = System.currentTimeMillis()-start;

        System.out.println("serial: " +time +"ms, b=" +b);

    }


}
