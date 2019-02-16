package com.concurrency.thread.priority;

import java.util.Random;

/**
 * Created by lenovo on 2017/10/10.
 */
public class PriorityTest2Thread extends Thread {
    private static Random random = new Random();

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {

                random.nextInt();
                addResult += i;
                //   System.out.print("#### addResult=" + addResult);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("######### current PrioprityTest2Thread used time =" + (endTime - beginTime));
    }

}
