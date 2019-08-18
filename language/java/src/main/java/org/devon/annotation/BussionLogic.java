package org.devon.annotation;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class BussionLogic {

    @MyAnnotation(id=5,name = "张三")
    public void method1(){
       // log.info("method1 is executing...");
    }

    @MyAnnotation
    public void method2(){
       // log.info("method2 is executing...");
    }



}
