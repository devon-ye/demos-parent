package org.devon.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenovo on 2017/12/5.
 */
public class SpringDemoApp {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringDemoApp springDemoApp = new SpringDemoApp();

    }

    public void initApplicationContext(String springBeanConfigFileName){
        applicationContext =new ClassPathXmlApplicationContext(springBeanConfigFileName);

    }

    public <T> T getBean(String beanName) {
        return (T)applicationContext.getBean(beanName);
    }
}
