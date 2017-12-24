package com.spring.demo.bean.autowiring;

/**
 * Created by lenovo on 2017/12/5.
 */
public class BeanAutoWiring {

    private BeanAutoWiringDao beanAutoWiringDao;



    public BeanAutoWiringDao getBeanAutoWiringDao() {
        return beanAutoWiringDao;
    }

    public void setBeanAutoWiringDao(BeanAutoWiringDao beanAutoWiringDao) {
        this.beanAutoWiringDao = beanAutoWiringDao;
    }

    public  void print() {
        System.out.println("BeanAutoWiring execute print method");
        this.beanAutoWiringDao.print();
    }
}
