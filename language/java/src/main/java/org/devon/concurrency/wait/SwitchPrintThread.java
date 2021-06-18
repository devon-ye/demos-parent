package org.devon.concurrency.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/5/28 20:49
 */
public class SwitchPrintThread implements Runnable{

    private Object lock;

    private List<Character> nums;

    private int size =0;


    public SwitchPrintThread(Object lock, List<Character> nums) {
        this.lock = lock;
        this.nums = nums;
        size = nums.size();
    }

    @Override
    public void run() {

        int i= 0;

        while (i<size){
            synchronized (lock){
                notify();
                System.out.println(this.nums.get(i));
                try {
                    this.wait();
                } catch (InterruptedException e) {

                }
            }
            i++;
        }
        notify();
    }

    public static void main(String[] args) {
        Object lock = new Object();
        List<Character> nums = new ArrayList<>();
        List<Character> letters = new ArrayList<>();

        SwitchPrintThread threaA = new SwitchPrintThread(lock,nums);
        SwitchPrintThread threaB = new SwitchPrintThread(lock,letters);

    }


}
