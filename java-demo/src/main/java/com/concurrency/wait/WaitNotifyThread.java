package com.concurrency.wait;

/**
 * Created by lenovo on 2017/11/24.
 */
public class WaitNotifyThread extends Thread {

    private PlusOperation plusOperation;

    public WaitNotifyThread(PlusOperation plusOperation) {
        this.plusOperation = plusOperation;
    }

    @Override
    public void run() {

        while (plusOperation.getAb().get()) {

            synchronized (plusOperation) {
                plusOperation.addInt(1, 1);
                plusOperation.notify();
            }
        }
        try {
            plusOperation.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
