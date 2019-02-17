package com.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/7/1 21:10
 * @since 1.0.0
 */
public class ApplicationMaster {
    private static final Logger LOG  = LoggerFactory.getLogger(ApplicationMaster.class);
    public static void main(String[] args) {
        LOG.info("ApplicationMaster execute starting...");
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        while (endTime - startTime > 2000) {
            try {
                Object object = new Object();
                object.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            endTime = System.currentTimeMillis();
        }
        LOG.info("ApplicationMaster execute end...");
    }
}
