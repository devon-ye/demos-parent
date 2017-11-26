package com.concurrency.synchronizeds;

/**
 * Created by lenovo on 2017/10/11.
 */
public class Test2Thread extends   Thread {
    private Task task;

    public Test2Thread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.doLongTimeTask();
    }
}
