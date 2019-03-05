package org.devon.concurrency.client.server.concurrent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author dewen.ye
 * @date 2019/3/5 23:50
 */
public class CleanCacheTask implements Runnable {
   private static  final Logger LOG = LoggerFactory.getLogger(CleanCacheTask.class);
    private final ParallelCache cache;


    public CleanCacheTask(ParallelCache cache) {
        this.cache = cache;
    }

    @Override
    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted()) {
                TimeUnit.SECONDS.sleep(10);
                cache.clean();
            }
        } catch (Exception e) {
          LOG.error("cache clean fail! Exception:",e);
        }
    }
}
