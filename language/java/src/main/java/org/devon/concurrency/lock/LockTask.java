package org.devon.concurrency.lock;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dewen.ye
 * @date 2019/3/18 08:50
 */
public class LockTask implements Runnable {

    private static ReentrantLock lock = new  ReentrantLock();
    private String name;


    public LockTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println("Task: " + name + "; Date: " + new Date() + ": Running the task");
            //todo task
            System.out.println("Task: " + name + "; Date: " + new Date() + ": The execution has finished");
        }finally {
            lock.unlock();
        }
    }
}
