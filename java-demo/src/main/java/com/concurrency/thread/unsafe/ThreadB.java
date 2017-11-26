package com.concurrency.thread.unsafe;

/**
 * Created by lenovo on 2017/10/10.
 */
public class ThreadB  extends  Thread {
    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("b");
    }
}
