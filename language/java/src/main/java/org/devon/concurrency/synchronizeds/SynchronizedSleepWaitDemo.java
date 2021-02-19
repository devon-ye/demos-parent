package org.devon.concurrency.synchronizeds;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/2/19 6:35 PM
 */
public class SynchronizedSleepWaitDemo implements Runnable {
    private  Object LOCK = new Object();

    private final String WAIT = "wait";

    private String method;

    public SynchronizedSleepWaitDemo(String method) {
        this.method = method;
    }

    public static void main(String[] args) {

        SynchronizedSleepWaitDemo waitDemo = new SynchronizedSleepWaitDemo("wait");
        Thread wait_thread1 = new Thread(waitDemo,"synchronized_wait_thread1");
        Thread wait_thread2 = new Thread(waitDemo,"synchronized_wait_thread2");

        SynchronizedSleepWaitDemo sleepDemo = new SynchronizedSleepWaitDemo("sleep");
        Thread sleep_thread1 = new Thread(sleepDemo,"synchronized_sleep_thread1");
        Thread sleepThread2 = new Thread(sleepDemo,"synchronized_sleep_thread2");
        wait_thread1.start();
        wait_thread2.start();
        sleep_thread1.start();
        sleepThread2.start();

    }


    private void testSynchronizedSleep() {
        while (true) {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName()+"    testSynchronizedSleep");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void testSynchronizedWait() {
        while (true) {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName()+"     testSynchronizedWait");
                try {
                    LOCK.wait(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        if (WAIT.equals(this.method)) {
            testSynchronizedWait();
        } else {
            testSynchronizedSleep();
        }
    }
}
