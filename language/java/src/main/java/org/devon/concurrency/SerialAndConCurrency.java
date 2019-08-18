package org.devon.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *@author  Devonmusa
 *@version 1.0.0
 *@datetime 2017年1月21日 上午1:00:08
 *
 */
public class SerialAndConCurrency {
    private static final Logger LOG = LoggerFactory.getLogger(SerialAndConCurrency.class);

    private static final long count = 100000L;

    public static void main(String[] args) {
        try {
            concurrency();
        } catch (InterruptedException e) {
            LOG.error("main, InterruptedException:{}", e);
        }
        serial();
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        LOG.info("serial time:{}ms,b:{}", time, b);

    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @SuppressWarnings("unused")
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;

        thread.join();
        LOG.info("concurrency time:{}ms,b:{}", time, b);

    }


}
