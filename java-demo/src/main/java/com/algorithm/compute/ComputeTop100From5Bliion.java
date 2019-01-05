package com.algorithm.compute;

import java.util.HashMap;
import java.util.Map;

/**
*@author  Devonmusa
*@date 2017年3月30日
*/
public class ComputeTop100From5Bliion {

    private volatile  Integer  integers;
    private Map<String,String> hashMap = new HashMap<String, String>(20);


    public synchronized  void gets(){

        Runnable myRunnable = new Runnable(){
            @Override
            public void run(){

                System.out.println("Runnable running");


            }

        };

        Thread thread = new Thread(myRunnable,"myRhread");

        thread.start();


    }

}
