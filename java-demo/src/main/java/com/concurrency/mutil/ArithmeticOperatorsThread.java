package com.concurrency.mutil;

import com.repeatecode.demo.Wind;

/**
 * Created by lenovo on 2017/11/22.
 */
public class ArithmeticOperatorsThread implements Runnable {

    private ArithmeticOperators arithmericOperators;

    public ArithmeticOperatorsThread(ArithmeticOperators ao) {
        this.arithmericOperators = ao;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 10; i++) {
            arithmericOperators.increment();
        }
    }


    public static void main(String[] args) {
        ArithmeticOperators arithmeticOperators = new ArithmeticOperators();

        ArithmeticOperatorsThread aot1 = new ArithmeticOperatorsThread(arithmeticOperators);
        Thread t1 = new Thread(aot1);
        Thread t2 = new Thread(aot1);
        Thread t3 = new Thread(aot1);
        t1.start();
        t2.start();
        t3.start();
    }
}
