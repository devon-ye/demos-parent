package com.concurrency.wait;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by lenovo on 2017/11/24.
 */
public class PlusOperation {
    private AtomicBoolean ab =new AtomicBoolean(false);
    private  int i;


    public int addInt(int a,int b) {

        int result = a+ b;

        return  result;
    }

    public double addInt(double a,double b) {

        double result = a+ b;

        return  result;
    }

    public float addInt(float a,float b) {

        float result = a+ b;

        return  result;
    }

    public AtomicBoolean getAb() {
        return ab;
    }

    public void setAb(AtomicBoolean ab) {
        this.ab = ab;
    }
}
