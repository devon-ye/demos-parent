package org.devon.concurrency.wait;

/**
 * Created by lenovo on 2017/10/26.
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            WaitThread wt = new WaitThread(lock);
            wt.start();

            Thread.sleep(3000);

            NotifyThread nt = new NotifyThread(lock);
            nt.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
