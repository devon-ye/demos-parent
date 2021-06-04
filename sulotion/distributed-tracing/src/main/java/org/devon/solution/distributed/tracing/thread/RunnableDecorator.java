package org.devon.solution.distributed.tracing.thread;

import org.devon.solution.distributed.tracing.TracingContext;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/6/5 00:06
 */
public class RunnableDecorator implements Runnable{
    private final Runnable runnable;
    private final String traceId;

    public RunnableDecorator(Runnable runnable) {
        this.runnable = runnable;
        this.traceId = TracingContext.getTraceId();
    }

    @Override
    public void run() {
        if (this.traceId != null) {
            try {
                TracingContext.setTraceId(this.traceId);
                this.runnable.run();
            } finally {
                TracingContext.removeTraceId();
            }
        } else {
            this.runnable.run();
        }
    }
}
