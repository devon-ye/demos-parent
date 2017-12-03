package com.concurrency.wait;

/**
 * Created by lenovo on 2017/12/3.
 */
public class AddOperatorWaitNodify {
    private boolean  flag = false;

    private int i=0;

    public AddOperatorWaitNodify(int i) {
        this.i = i;
    }

    public synchronized void add() {
        if(!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i++;
        flag = false;
        this.notify();
    }

    public synchronized void print() {
        if(flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread.currentThread:" + Thread.currentThread() + ", i=" + i);
        flag = true;
        this.notify();
    }
}
