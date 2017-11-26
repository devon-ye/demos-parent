package com.concurrency.thread.priority;

import java.util.Random;

/**
 * Created by lenovo on 2017/10/10.
 */
public class PriorityTest1Thread extends Thread{

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for(int j=0;j<10;j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult += i;
              //  System.out.print("@@@@ addResult=" + addResult);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("@@@@@@@@ current PrioprityTest1Thread used time =" + (endTime-beginTime));
    }
}
