package org.devon.solution.distributed.tracing.spring.filter;

import org.devon.solution.distributed.tracing.TracingContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/6/5 00:13
 */
public class ClearFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(request, response);
        } finally {
            TracingContext.removeTraceId();
        }
    }

    @Override
    public void destroy() {

    }
}
