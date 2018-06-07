package com.concurrency.synchronizeds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lenovo on 2017/10/11.
 */
public class Task {
   private static final Logger log = LoggerFactory.getLogger(Task.class);

    public void doLongTimeTask() {
        for(int i = 0 ; i <  100 ; i ++) {
            log.info("###asynchronized threadName=" +Thread.currentThread().getName() + ", i=" +(i+1));
        }

        log.info("");

        synchronized(this){
            for(int i = 0 ; i <  100 ; i ++) {
                log.info("synchronized threadName=" +Thread.currentThread().getName() + ", i=" +(i+1));
            }
        }

    }


}
