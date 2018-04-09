package com.redis.demo;

import com.redis.demo.repository.StringSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public class SpringRedisApp {

    private static ApplicationContext applicationContext;
    private  String key = "number.section";
    @Autowired
    private  StringSetRepository stringSetRepository;

    public void init() {

    }

    public static void main(String[] args) {
        try {
            applicationContext =new  ClassPathXmlApplicationContext("spring-redis.xml");
            SpringRedisApp springRedisApp = (SpringRedisApp) applicationContext.getBean("SpringRedisApp");
           // stringSetRepository = (StringSetRepository) applicationContext.getBean("stringSetRepository");
            springRedisApp.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void start(){
        Set<String> stringSet = new HashSet<>();
        stringSet.add("189");
        stringSet.add("188");
        stringSet.add("187");
        stringSet.add("185");
        stringSet.add("184");
        stringSetRepository.add(key,stringSet);
        stringSetRepository.list(key);

    }
}
