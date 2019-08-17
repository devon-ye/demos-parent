package org.devon.concurrency.lock.clazz;

/**
 * Created by lenovo on 2017/10/12.
 */
public class TestThreadA extends Thread{

    private Service service;

    public TestThreadA(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.printA();
    }

}
