package com.concurrency.wait;

/**
 * Created by lenovo on 2017/12/3.
 */
public class AddThread implements Runnable {

    private AddOperatorWaitNodify addOperatorWaitNodify;

    public AddThread(AddOperatorWaitNodify addOperatorWaitNodify) {
        this.addOperatorWaitNodify = addOperatorWaitNodify;
    }


    @Override
    public void run() {
        this.addOperatorWaitNodify.add();
    }


}
