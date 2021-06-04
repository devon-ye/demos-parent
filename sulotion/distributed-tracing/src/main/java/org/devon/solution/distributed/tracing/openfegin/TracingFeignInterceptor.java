package org.devon.solution.distributed.tracing.openfegin;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.devon.solution.distributed.tracing.TracingContext;
import org.slf4j.MDC;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2020/12/26 4:45 PM
 */

public class TracingFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String traceId = TracingContext.getTraceId();
        if (traceId != null) {
            MDC.put(TracingContext.LOG_PATTER_TRACE_ID, traceId);
            template.header(TracingContext.TRACE_ID_KEY, traceId);
        }
    }
}
