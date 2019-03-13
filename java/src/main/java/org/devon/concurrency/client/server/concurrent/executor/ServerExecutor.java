package org.devon.concurrency.client.server.concurrent.executor;

import com.sun.scenario.effect.impl.prism.PrImage;
import org.devon.concurrency.client.server.concurrent.service.ConcurrentCommand;
import org.devon.concurrency.client.server.concurrent.service.ServerTask;
import org.devon.concurrency.client.server.log.Logger;
import org.devon.jdbc.DatabaseConnectPool;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:38
 */
public class ServerExecutor extends ThreadPoolExecutor {
    private ConcurrentHashMap<Runnable, Date> startTimes;
    private ConcurrentHashMap<String, ExecutorStatistics> executorStatistics;

    private static int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static int MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static long KEEP_LIVE_TIME = 10;

    private static RejectedTaskController REJECTED_TASK_CONTROLLER = new RejectedTaskController();

    public ServerExecutor() {
        super(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_LIVE_TIME, TimeUnit.SECONDS, new PriorityBlockingQueue<>(), REJECTED_TASK_CONTROLLER);
    }

    @Override
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        startTimes.put(runnable, new Date());
    }

    @Override
    public void afterExecute(Runnable runnable, Throwable t) {
        super.afterExecute(runnable, t);
        ServerTask<?> task = (ServerTask<?>) runnable;
        ConcurrentCommand command = task.getCommand();

        if (t == null) {
            if(!task.isCancelled()){

            }

        }else {
            Logger.sendMessage("The Exception " + t.getMessage() + " has been thrown.");
        }
    }
}
