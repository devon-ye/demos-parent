package org.devon.concurrency.client.server.log;


import java.util.concurrent.TimeUnit;

/**
 * @author dewen.ye
 * @date 2019/3/13 08:35
 */
public class LogTask implements Runnable {
    @Override
    public void run() {
        try {
            while (Thread.currentThread().isInterrupted()) {

                TimeUnit.SECONDS.sleep(10);

                Logger.writeLogs();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Logger.writeLogs();
    }
}
