package org.devon.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
public class MyAnnotationHandler {


    public static void main(String[] args) {
        BussionLogic bussionLogic = new BussionLogic();
        MyAnnotationHandler.handAnnotion(bussionLogic);
    }


    private  static void handAnnotion(Object object){

        Method[] methdos=  object.getClass().getDeclaredMethods();
        for (Method methdo : methdos) {
            Annotation[] annotations = methdo.getAnnotations();
            MyAnnotationHandler.methodsAnnotationHandler(annotations,methdo);
        }
        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
          //  field.set(object,annotations);
            MyAnnotationHandler.filedAnnotstionHandler(annotations,field);
        }


      // log.info("id:{},name:{}",myAnnotation.id(),myAnnotation.name());

    }

    private static void filedAnnotstionHandler(Annotation[] annotations, Field value){
        for (Annotation annotation : annotations) {
            if(annotation instanceof  MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
              //  value.set(myAnnotation.id()+"",myAnnotation.name());
            }

        }
    }

    private static void methodsAnnotationHandler(Annotation[] annotations, Object value) {

    }
}
