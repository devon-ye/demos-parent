package com.concurrency.mutil;

/**
 * Created by lenovo on 2017/11/22.
 */
public class ArithmeticOperators {

    private  int i = 0;

    public long addOperator(long a,long b) {
        return a + b;
    }

    public synchronized long increment() {
        System.out.println("currentThread:" + Thread.currentThread() + ",i=" + i);
        return i+=1;
    }
}
