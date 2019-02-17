package org.devon.concurrency.volatiles;

/**
 * Created by lenovo on 2017/10/25.
 */
public class VolatileTestThread extends  Thread {

    public volatile static int count;
    //静态同步方法，所锁定的内容就是VolatileTestThread.Class了
    private static synchronized void addCount() {

        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void  run() {
        addCount();
    }

    public static void main(String[] args) {
        VolatileTestThread[] volatileTestThreads = new VolatileTestThread[100];
        for (int i = 0; i <100 ; i++) {
            volatileTestThreads[i] = new VolatileTestThread();
        }

        for (int i = 0; i <100 ; i++) {
            volatileTestThreads[i].start();
        }
    }
}
