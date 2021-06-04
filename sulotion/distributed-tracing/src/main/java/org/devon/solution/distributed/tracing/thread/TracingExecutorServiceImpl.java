package org.devon.solution.distributed.tracing.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author devon.ye@foxmail.com
 * @datetime: 2021/6/5 00:06
 * @description threadPoolExecutor线程池的tracing
 */
public class TracingExecutorServiceImpl implements ExecutorService {

    private ExecutorService executorService;


    public TracingExecutorServiceImpl(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return executorService.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return executorService.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return executorService.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executorService.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executorService.submit(new CallableDecorator<>(task));
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return executorService.submit(new RunnableDecorator(task), result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return executorService.submit(new RunnableDecorator(task));
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        Collection<CallableDecorator<T>> collection = new ArrayList<>(tasks.size());
        for (Callable<T> task : tasks) {
            collection.add(new CallableDecorator<>(task));
        }
        return executorService.invokeAll(collection);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        Collection<CallableDecorator<T>> collection = new ArrayList<>(tasks.size());
        for (Callable<T> task : tasks) {
            collection.add(new CallableDecorator<>(task));
        }
        return executorService.invokeAll(collection, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        Collection<CallableDecorator<T>> collection = new ArrayList<>(tasks.size());
        for (Callable<T> task : tasks) {
            collection.add(new CallableDecorator<>(task));
        }
        return executorService.invokeAny(collection);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        Collection<CallableDecorator<T>> collection = new ArrayList<>(tasks.size());
        for (Callable<T> task : tasks) {
            collection.add(new CallableDecorator<>(task));
        }
        return executorService.invokeAny(collection, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        executorService.execute(new RunnableDecorator(command));
    }
}
