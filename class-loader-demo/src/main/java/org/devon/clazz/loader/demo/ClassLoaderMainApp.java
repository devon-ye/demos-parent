package org.devon.clazz.loader.demo;

import java.util.ServiceLoader;

/**
 * @author dewen.ye
 * @date 2019/1/3 00:45
 */
public class ClassLoaderMainApp {


    public static void main(String[] args) {

      ServiceLoader<ClassLoaderMainApp>  loader =  ServiceLoader.load(ClassLoaderMainApp.class);
    }
}
