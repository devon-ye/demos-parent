package org.servlet.demo.filter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ElasticLoadBalancingFilter implements Filter {

    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1,
            new NamedThreadFactory("system-listener-task", true));


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

    public static class NamedThreadFactory implements ThreadFactory {

        private final AtomicInteger threadNumber = new AtomicInteger(1);

        private final String namePrefix;
        private final boolean daemon;

        public NamedThreadFactory(String namePrefix, boolean daemon) {
            this.daemon = daemon;
            this.namePrefix = namePrefix;
        }

        public NamedThreadFactory(String namePrefix) {
            this(namePrefix, false);
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread( r, namePrefix + "-thread-" + threadNumber.getAndIncrement());
            t.setDaemon(daemon);
            return t;
        }
    }
}
