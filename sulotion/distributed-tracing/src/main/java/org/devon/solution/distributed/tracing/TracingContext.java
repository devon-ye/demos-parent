package org.devon.solution.distributed.tracing;

import org.slf4j.MDC;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/6/5 00:03
 */
public class TracingContext {

    public static final String TRACE_ID_KEY = "trace_id";

    public static final String LOG_PATTER_TRACE_ID = "traceId";

    private static ThreadLocal<String> TRACE_ID_THREAD_LOCAL = new ThreadLocal<String>();

    public static void setTraceId(String value) {
        if (null != value) {
            TRACE_ID_THREAD_LOCAL.set(value);
            MDC.put(TracingContext.LOG_PATTER_TRACE_ID, value);
        }
    }

    public static String getTraceId() {
        return TRACE_ID_THREAD_LOCAL.get();
    }

    public static void removeTraceId() {
        TRACE_ID_THREAD_LOCAL.remove();
        MDC.remove(TracingContext.LOG_PATTER_TRACE_ID);
    }

    public static void reset() {
        TRACE_ID_THREAD_LOCAL.remove();
    }
}
