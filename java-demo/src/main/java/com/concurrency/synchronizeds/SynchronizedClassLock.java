package com.concurrency.synchronizeds;

/**
 * @author dewen.ye
 * @date 2019/1/11 01:13
 */
public class SynchronizedClassLock {

    public static synchronized void staticMethodLock() {

    }

    public void classObjectLock() {
        synchronized (SynchronizedClassLock.class) {

        }
    }
}
