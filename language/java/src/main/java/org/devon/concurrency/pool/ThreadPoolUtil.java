package org.devon.concurrency.pool;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/11 0:42
 * @since 1.0.0
 */
public class ThreadPoolUtil {

    private static final Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
    private static final Executor  cachedThreadPool= Executors.newCachedThreadPool();
    private static final Executor  fixedThreadPool =  Executors.newFixedThreadPool(2);
    private static final Executor  singleScheduleThreadPool = Executors.newSingleThreadScheduledExecutor();
    private static final  Executor scheduleThreadPool = Executors.newScheduledThreadPool(2);
    private static final Executor WorkStealingPool = Executors.newWorkStealingPool();
     private ThreadPoolExecutor executorService = new ThreadPoolExecutor(1,1,1, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(2))

    private ThreadPoolUtil() {
       ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        MemoryMXBean memoryMXBean =ManagementFactory.getMemoryMXBean();
        ManagementFactory.getPlatformMBeanServer().getDefaultDomain();
    }


}
