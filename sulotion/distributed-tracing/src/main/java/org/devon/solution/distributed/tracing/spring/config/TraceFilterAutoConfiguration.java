package org.devon.solution.distributed.tracing.spring.config;


import org.devon.solution.distributed.tracing.spring.filter.ClearFilter;
import org.devon.solution.distributed.tracing.spring.filter.TracingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import java.util.ArrayList;


/**
 * @author devon.ye@foxmail.com
 * @datetime: 2021/6/5 00:08
 */
public class TraceFilterAutoConfiguration {

    @Bean("tracingFilterRegistryBean")
    public FilterRegistrationBean registryTraceFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TracingFilter traceFilter = new TracingFilter();
        registrationBean.setFilter(traceFilter);
        registrationBean.setName(TracingFilter.class.getSimpleName());
        ArrayList<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE - 200);
        return registrationBean;
    }

    @Bean("clearFilterRegistryBean")
    public FilterRegistrationBean registryClearFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        ClearFilter traceFilter = new ClearFilter();
        registrationBean.setFilter(traceFilter);
        registrationBean.setName(ClearFilter.class.getSimpleName());
        ArrayList<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registrationBean;
    }
}
