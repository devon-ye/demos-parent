package org.devon.concurrency.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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


    private ThreadPoolUtil() {
    }


}
