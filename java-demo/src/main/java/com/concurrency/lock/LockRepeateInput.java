package com.concurrency.lock;

/**
 * Created by lenovo on 2017/10/11.
 */
public class LockRepeateInput {

    public synchronized void synchronizedMethod1() {
        System.out.println("synchronizedMethod1!");
        synchronizedMethod2();
    }

    public synchronized void synchronizedMethod2() {
        System.out.println("synchronizedMethod2!");
        synchronizedMethod3();
    }

    public synchronized void synchronizedMethod3() {
        System.out.println("synchronizedMethod3!");
    }
}
