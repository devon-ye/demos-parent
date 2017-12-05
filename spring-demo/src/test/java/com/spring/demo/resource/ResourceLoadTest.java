package com.spring.demo.resource;

import com.spring.demo.SpringDemoApp;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

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
