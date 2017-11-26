package com.concurrency.lock.clazz;

import com.concurrency.thread.unsafe.ThreadB;

/**
 * Created by lenovo on 2017/10/12.
 */
public class ClassSynchronizedLockTest {

    public static void main(String[] args) {
        Service serviceA = new Service();
        Service serviceB = new Service();

        TestThreadA tta= new TestThreadA(serviceA);
        tta.start();

        TestThreadB ttb = new TestThreadB(serviceB);
        ttb.start();
    }
}
