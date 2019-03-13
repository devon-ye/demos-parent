package org.devon.concurrency.client.server.concurrent.service;

import org.devon.concurrency.client.server.concurrent.executor.ConcurrentCommand;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:49
 */
public class ServerTask<T>  implements RunnableFuture<T> {
    private ConcurrentCommand command;

    public ServerTask(Runnable r) {

    }

    public ConcurrentCommand getCommand() {
        return command;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }


    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }



    @Override
    public void run() {

    }
}
