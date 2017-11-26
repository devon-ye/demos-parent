package com.concurrency.thread.priority;

/**
 * Created by lenovo on 2017/10/10.
 */
public class ThreadPriorityCompare {

    public static void main(String args[]) {
        for(int i=0;i <30;i++) {
            PriorityTest1Thread pt1t = new PriorityTest1Thread();
            pt1t.setPriority(10);
            pt1t.start();
            PriorityTest2Thread pt2t = new PriorityTest2Thread();
            pt2t.setPriority(1);
            pt2t.start();
        }

    }
}
