package org.devon.solution.distributed.tracing.spring;

import org.devon.solution.distributed.tracing.thread.RunnableDecorator;
import org.springframework.core.task.TaskDecorator;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/6/5 00:08
 */
public class TracingTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        return new RunnableDecorator(runnable);
    }
}
