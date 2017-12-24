package com.ecas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenovo on 2017/12/9.
 */
public class EcasApp {
    public static void main(String[] args) {

    }

    private void init() {
        initApplicationContext();
    }

    private void initApplicationContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./");
    }
}
