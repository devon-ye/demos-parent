package com.design.pattern.singleton;

/**
 * Created by lenovo on 2017/10/25.
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton instance=null;

    private DoubleCheckSingleton(){}



    public static DoubleCheckSingleton getInstances() {

        if(instance==null){
            synchronized (LazySingleton.class){
                if(instance == null) {
                    instance=new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
