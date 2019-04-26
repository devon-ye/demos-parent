package org.devon.concurrency.client.server.V2;


import java.net.ServerSocket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dewen.ye
 * @date 2019/3/3 20:55
 */
public class ConcurrentServer {

    private static ThreadPoolExecutor executor;
    private static ServerSocket serverSocket;
    private static ParallelCache cache;
    private static volatile boolean stoped = false;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        cache = new ParallelCache();
        //

    }

    public static ParallelCache getCache() {
        return cache;
    }

    public static ThreadPoolExecutor getExecutor() {
        return executor;
    }
}
