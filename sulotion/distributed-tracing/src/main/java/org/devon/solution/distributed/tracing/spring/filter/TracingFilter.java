package org.devon.solution.distributed.tracing.spring.filter;


import org.devon.solution.distributed.tracing.IdGenerator;
import org.devon.solution.distributed.tracing.TracingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/6/5 00:10
 */
public class TracingFilter implements Filter{

    private static final Logger LOG = LoggerFactory.getLogger(TracingContext.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("TraceFilter init filterConfig");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String traceId = httpServletRequest.getHeader(TracingContext.TRACE_ID_KEY);
        if (null != traceId) {
            TracingContext.setTraceId(traceId);
        }else {
            TracingContext.setTraceId(IdGenerator.generatorTraceId());
        }
        chain.doFilter(httpServletRequest, response);
    }

    @Override
    public void destroy() {
        LOG.info("TraceFilter destroy!");
    }
}
