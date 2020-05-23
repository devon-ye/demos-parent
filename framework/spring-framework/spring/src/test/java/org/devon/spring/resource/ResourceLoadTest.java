package org.devon.spring.resource;

import org.devon.spring.SpringDemoApp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lenovo on 2017/12/5.
 */

public class ResourceLoadTest extends SpringDemoApp {
    private static final String SPRING_COFIG_FILE="spring-beans-resource-load.xml";
    @Before
    public void setUp() throws Exception {
        super.initApplicationContext(SPRING_COFIG_FILE);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setApplicationContext() throws Exception {

    }

    @Test
    public void loadResource()   {
        try {
        ResourceLoad resourceLoad =  super.getBean("resourceLoad");
        resourceLoad.loadResource();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
