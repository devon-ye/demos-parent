package com.spring.demo.bean.lifecycle;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * Created by lenovo on 2017/12/4.
 */

public class BeanlifeCycleTest {
   // private static final String SPRING_CONFIG_FILE = "spring-beans-life-cycle.xml";
    private  ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception {
        applicationContext = new FileSystemXmlApplicationContext("classpath:spring-beans-life-cycle.xml");


    }

    @Test
    public void testIterfaceImpl() {
        BeanLifeCycleImplnterface beanLifeCycleImplnterface = (BeanLifeCycleImplnterface) applicationContext.getBean("beanlifeCycleImplnterface");
        try {
            beanLifeCycleImplnterface.afterPropertiesSet();
            Thread.sleep(5000);
            beanLifeCycleImplnterface.destroy();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testConfigMethod() {
        applicationContext.getBean("beanlifeCycleConfigMethod");
    }



    @After
    public void tearDown() throws Exception {

    }



}
