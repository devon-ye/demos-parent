package org.devon.solution.distributed.tracing.grpc;

import io.grpc.*;
import org.devon.solution.distributed.tracing.TracingContext;

import java.util.Set;

/**
 * @author devon.ye@foxmail.com
 * @datetime 2020/7/1 4:17 PM
 * @description
 */
public class TracingServerInterceptor implements ServerInterceptor {
    private static final Metadata.Key<String> TRACE_ID_KEY = Metadata.Key.of(TracingContext.TRACE_ID_KEY, Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata header,
            ServerCallHandler<ReqT, RespT> serverCallHandler) {
        Set<String> keys = header.keys();
        for (String key : keys) {
            if (TracingContext.TRACE_ID_KEY.equals(key)) {
                String traceId = header.get(TRACE_ID_KEY);
                header.removeAll(TRACE_ID_KEY);
                TracingContext.setTraceId(traceId);
                break;
            }
        }
        return new TracingForwardingServerCallListener(serverCallHandler.startCall(serverCall, header), serverCall.getMethodDescriptor());
    }

    public ServerServiceDefinition intercept(ServerServiceDefinition serviceDef) {
        return ServerInterceptors.intercept(serviceDef, this);
    }

    class TracingForwardingServerCallListener<RequestT> extends ForwardingServerCallListener.SimpleForwardingServerCallListener<RequestT> {

        public TracingForwardingServerCallListener(ServerCall.Listener<RequestT> listener, MethodDescriptor<RequestT, ?> descriptor) {
            super(listener);
        }

        @Override
        public void onMessage(RequestT message) {
            super.onMessage(message);
        }

        @Override
        public void onCancel() {
            try {
                super.onCancel();
            } catch (Throwable t) {
                throw t;
            } finally {
                TracingContext.removeTraceId();
            }
        }

        @Override
        public void onComplete() {
            try {
                delegate().onComplete();
            } catch (Throwable t) {
                throw t;
            } finally {
                TracingContext.removeTraceId();
            }
        }

        @Override
        public void onHalfClose() {
            try {
                super.onHalfClose();
            } catch (Throwable t) {
                throw t;
            } finally {
                TracingContext.removeTraceId();
            }
        }
    }
}
