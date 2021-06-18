package org.devon.solution.distributed.tracing.grpc;

import io.grpc.*;
import org.devon.solution.distributed.tracing.TracingContext;

/**
 * @author devon.ye@foxmail.com
 * @datetime 2020/7/1 4:17 PM
 * @description
 */

public class TracingClientInterceptor implements ClientInterceptor {
    private static final Metadata.Key<String> TRACE_ID_KEY = Metadata.Key.of(TracingContext.TRACE_ID_KEY, Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ForwardingClientCall.SimpleForwardingClientCall interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
                                                                                       CallOptions callOptions, Channel channel) {

        return new ForwardingClientCall.SimpleForwardingClientCall(channel.newCall(methodDescriptor, callOptions)) {
            @Override
            public void start(Listener responseListener, Metadata headers) {
                String traceId = TracingContext.getTraceId();
                if (traceId != null) {
                    headers.put(TRACE_ID_KEY, traceId);
                }
                super.start(responseListener, headers);
            }
        };
    }


}
