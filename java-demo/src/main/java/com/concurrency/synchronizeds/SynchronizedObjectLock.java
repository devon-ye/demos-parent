package com.concurrency.synchronizeds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lenovo on 2019/01/11.
 */
public class SynchronizedObjectLock {
    private static final Logger log = LoggerFactory.getLogger(SynchronizedObjectLock.class);
    private Object object = new Object();

    public void codeBlockLockThis() {
        for (int i = 0; i < 100; i++) {
            log.info("###asynchronized threadName=" + Thread.currentThread().getName() + ", i=" + (i + 1));
        }
        log.info("");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                log.info("synchronized threadName=" + Thread.currentThread().getName() + ", i=" + (i + 1));
            }
        }

    }

    public void codeBlockLockOtherObject() {
        for (int i = 0; i < 100; i++) {
            log.info("###asynchronized threadName=" + Thread.currentThread().getName() + ", i=" + (i + 1));
        }
        log.info("");
        synchronized (object) {
            for (int i = 0; i < 100; i++) {
                log.info("synchronized threadName=" + Thread.currentThread().getName() + ", i=" + (i + 1));
            }
        }

    }

    public synchronized void methodBlockLockCurrentObject() {
        for (int i = 0; i < 100; i++) {
            log.info("###asynchronized threadName=" + Thread.currentThread().getName() + ", i=" + (i + 1));
        }
        log.info("");
        for (int i = 0; i < 100; i++) {
            log.info("synchronized threadName=" + Thread.currentThread().getName() + ", i=" + (i + 1));
        }
    }

}
