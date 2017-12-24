package com.spring.demo.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by lenovo on 2017/12/5.
 */
public class ResourceLoad implements ApplicationContextAware{
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void loadResource() {
        Resource resourceClasspath =  applicationContext.getResource("classpath:resource-config.xml");
        Resource resourceUrl =  applicationContext.getResource("file:resource-config.xml");
        Resource resourceFile =  applicationContext.getResource("url:https://docs.spring.io/spring/docs/4.3.13.RELEASE/javadoc-api/");
       Resource resource =  applicationContext.getResource("resource-config.xml");
        System.out.println("resourceFileName:" +resource.getFilename());

        try {
            System.out.println("resourceFile lastModified:" +resource.lastModified());
            System.out.println("resourceFileSize:" +resource.getFile().length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
