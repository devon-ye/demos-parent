package org.devon.concurrency.wait;

/**
 * Created by lenovo on 2017/10/26.
 */
public class WaitThread extends  Thread {
    private volatile boolean  isRunning;
    private Object lock;
    public WaitThread(Object lock){
        this.lock = lock;
    }


    @Override
    public void run() {
        try {
            while(isRunning) {
                synchronized (lock) {
                    System.out.println("string  wait time=" + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("ending  wait time=" + System.currentTimeMillis());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
