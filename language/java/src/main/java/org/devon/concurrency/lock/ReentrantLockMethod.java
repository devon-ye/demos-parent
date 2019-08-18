package org.devon.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dewen.ye
 * @date 2019/4/1 08:26
 */
public class ReentrantLockMethod {
    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

    }

    public void printReentrantLockProperties() {
        boolean hasQueueThreads = reentrantLock.hasQueuedThreads();
        int waitThreadSize = reentrantLock.getQueueLength();
        int currentThreadGetLockCount = reentrantLock.getHoldCount();
    }

}
