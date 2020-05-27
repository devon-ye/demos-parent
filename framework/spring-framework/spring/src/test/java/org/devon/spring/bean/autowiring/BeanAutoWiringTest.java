package org.devon.spring.bean.autowiring;

import org.devon.spring.SpringDemoApp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by lenovo on 2017/12/5.
 */

public class BeanAutoWiringTest extends SpringDemoApp{
    private static final String SPRING_CONFIG_FILE = "spring-beans-auto-wiring.xml";

    @Before
    public void setUp() throws Exception {
        super.initApplicationContext(SPRING_CONFIG_FILE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBeanAutoWiringDao() throws Exception {
    }

    @Test
    public void setBeanAutoWiringDao() throws Exception {
    }

    @Test
    public void testPrint() {
        try {
            BeanAutoWiring  beanAutoWiring  =  super.getBean("beanAutoWiring");
            beanAutoWiring.print();
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
