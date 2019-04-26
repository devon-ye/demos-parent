package org.devon.concurrency.synchronizeds;

/**
 * Created by lenovo on 2017/10/11.
 */
public class TestRunMain {

    public static void main(String[] args) {
        SynchronizedObjectLock task = new SynchronizedObjectLock();

        Test1Thread t1t = new Test1Thread(task);
        t1t.start();

        Test2Thread t2t = new Test2Thread(task);
        t2t.start();
    }
}


