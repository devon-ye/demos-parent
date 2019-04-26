package org.devon.concurrency.client.server.V3;

import org.devon.concurrency.client.server.V2.ConcurrentCommand;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:49
 */
public class ServerTask<T> extends FutureTask<T> implements Runnable,Comparable<ServerTask<T>> {
    private ConcurrentCommand command;

    public ServerTask(ConcurrentCommand command) {
        super(command, null);
        this.command = command;
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

    @Override
    public int compareTo(ServerTask<T> o) {
        return command.compareTo(o.getCommand());
    }
}
