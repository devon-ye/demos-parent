package com.concurrency.wait;

/**
 * Created by lenovo on 2017/12/3.
 */
public class AddThreadTest {

    public static void main(String[] args) {
        AddOperatorWaitNodify addOperatorWaitNodify = new AddOperatorWaitNodify(7);
        AddThread addThread = new AddThread(addOperatorWaitNodify);
        PrintThread printThread = new PrintThread(addOperatorWaitNodify);
        int i=0;
        while (i<20) {
            new Thread(addThread).start();
            new Thread(printThread).start();
            i++;
        }


    }
}
