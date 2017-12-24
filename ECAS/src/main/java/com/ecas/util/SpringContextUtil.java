package com.ecas.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by devon on 2017/12/24.
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public Object getBeanByBeanName(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public <T> Object getBeanByClass(Class <T> classType) {
        return applicationContext.getBean(classType);
    }
}
