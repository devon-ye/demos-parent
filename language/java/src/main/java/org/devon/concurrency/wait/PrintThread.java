package org.devon.concurrency.wait;

/**
 * Created by lenovo on 2017/12/3.
 */
public class PrintThread implements Runnable{
    private AddOperatorWaitNodify addOperatorWaitNodify;

    public PrintThread(AddOperatorWaitNodify addOperatorWaitNodify) {
        this.addOperatorWaitNodify = addOperatorWaitNodify;
    }

    @Override
    public void run() {
        this.addOperatorWaitNodify.print();
    }
}
