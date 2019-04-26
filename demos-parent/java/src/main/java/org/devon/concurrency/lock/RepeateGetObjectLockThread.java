package org.devon.concurrency.lock;

/**
 * Created by lenovo on 2017/10/11.
 */
public class RepeateGetObjectLockThread extends  Thread {

    @Override
    public void run() {
        LockRepeateInput lri= new LockRepeateInput();
        lri.synchronizedMethod1();
    }

    public static void main(String[] args) {
        RepeateGetObjectLockThread rgolt = new RepeateGetObjectLockThread();
        rgolt.start();
    }
}
