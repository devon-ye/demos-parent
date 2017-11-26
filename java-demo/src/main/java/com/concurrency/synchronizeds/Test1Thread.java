package com.concurrency.synchronizeds;

/**
 * Created by lenovo on 2017/10/11.
 */
public class Test1Thread extends  Thread {
    private Task task;

    public Test1Thread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.doLongTimeTask();
    }
}
