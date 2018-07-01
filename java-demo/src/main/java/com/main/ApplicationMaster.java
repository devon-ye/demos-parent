package com.main;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/7/1 21:10
 * @since 1.0.0
 */
public class ApplicationMaster {

    public static void main(String[] args) {

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("ApplicationMaster###");

        }

    }
}
