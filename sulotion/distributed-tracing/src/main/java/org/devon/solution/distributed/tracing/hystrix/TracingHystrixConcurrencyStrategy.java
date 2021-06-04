package org.devon.solution.distributed.tracing.hystrix;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.devon.solution.distributed.tracing.thread.CallableDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * 复写Callable,基于SPI在HystrixPlugin中被加载
 *
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/1/13 11:24 AM
 */
public class TracingHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
    private static final Logger LOG = LoggerFactory.getLogger(TracingHystrixConcurrencyStrategy.class);


    public TracingHystrixConcurrencyStrategy() {
        LOG.info("TracingHystrixConcurrencyStrategy init!");
    }

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new CallableDecorator<>(callable);
    }
}
