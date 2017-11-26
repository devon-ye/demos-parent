package com.concurrency;

/**
 * Created by lenovo on 2017/10/8.
 */
public class ShareDataThread extends  Thread {
    private int count = 5;

    @Override
    public synchronized  void run(){  // jdk1.7
  //  public void run() { //jdk1.8
        super.run();
        count--;
        System.out.println("current" + this.currentThread().getName() + "computed , count=" + this.count);

    }

    public static void main(String args[]) {
        ShareDataThread sdt = new ShareDataThread();
        Thread t1 = new Thread(sdt,"A");
        Thread t2 = new Thread(sdt,"B");
        Thread t3 = new Thread(sdt,"C");
        Thread t4 = new Thread(sdt,"D");
        Thread t5 = new Thread(sdt,"E");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
