package org.devon.concurrency.synchronizeds;

/**
 * Created by lenovo on 2017/10/11.
 */
public class Test2Thread extends   Thread {
    private SynchronizedObjectLock task;

    public Test2Thread(SynchronizedObjectLock task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.codeBlockLockThis();
    }
}