package org.devon.solution.distributed.tracing.thread;

import org.devon.solution.distributed.tracing.TracingContext;

import java.util.concurrent.Callable;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/6/5 00:01
 */
public class CallableDecorator<V> implements Callable<V> {
    private final Callable<V> callable;
    private final String traceId;

    public CallableDecorator(Callable callable) {
        this.callable = callable;
        this.traceId = TracingContext.getTraceId();
    }

    @Override
    public V call() throws Exception {
        if (this.traceId != null) {
            try {
                TracingContext.setTraceId(this.traceId);
                return this.callable.call();
            } finally {
                TracingContext.removeTraceId();
            }
        } else {
            return this.callable.call();
        }
    }
}
