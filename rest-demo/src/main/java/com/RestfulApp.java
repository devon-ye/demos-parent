package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by lenovo on 2017/11/26.
 */
@SpringBootApplication
public class RestfulApp {
    private static Logger log = LoggerFactory.getLogger(RestfulApp.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(RestfulApp.class,args);
        }catch (Exception e){
            log.error("RestfulApp start failed! Exception:",e);
        }catch (Throwable t){
            log.error("RestfulApp start failed! Throwable:",t);
        }

    }
}
