package org.devon.spring.bean.lifecycle;



/**
 * Created by lenovo on 2017/12/4.
 */
public class BeanlifeCycleConfigMethod {

    public void init() {
        System.out.println("init method!!!!!");
    }


    public void destroy() {
        System.out.println("destroy method!!!");
    }

}
