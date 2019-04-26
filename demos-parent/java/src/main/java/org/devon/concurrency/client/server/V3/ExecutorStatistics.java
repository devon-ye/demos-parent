package org.devon.concurrency.client.server.V3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author dewen.ye
 * @date 2019/3/13 23:30
 */
public class ExecutorStatistics {
    private AtomicLong executionTime = new AtomicLong(0L);
    private AtomicInteger numTasks = new AtomicInteger(0);

    public void addExecutionTime(long time){
        executionTime.addAndGet(time);
    }

    public void addTask(){
        numTasks.incrementAndGet();
    }

    public AtomicLong getExecutionTime() {
        return executionTime;
    }

    public AtomicInteger getNumTasks() {
        return numTasks;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"executionTime\":")
                .append(executionTime);
        sb.append(",\"numTasks\":")
                .append(numTasks);
        sb.append('}');
        return sb.toString();
    }
}
