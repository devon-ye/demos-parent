package com.concurrency.thread.unsafe;

/**
 * Created by lenovo on 2017/10/10.
 */
public class TwoObjectTwoLock {

    public static void main(String[] args) {
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();

        ThreadA ta = new ThreadA(numRef1);
        ThreadB tb = new ThreadB(numRef2);
        ta.start();
        tb.start();

    }
}
