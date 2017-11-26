package com.concurrency.thread.unsafe;

/**
 * Created by lenovo on 2017/10/10.
 */
public class HasSelfPrivateNum {
    private int num = 0;
    public synchronized void addI(String userName) {
        try {
            if("a".equals(userName)){
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println("userName=" +userName + ",num=" +num);

        }catch (Exception e){

        }

    }
}
