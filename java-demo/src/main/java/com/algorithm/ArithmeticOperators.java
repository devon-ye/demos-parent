package com.algorithm;

/**
 * Created by lenovo on 2017/11/11.
 */
public class ArithmeticOperators {

    public void iAfterAdd() {
        int i= 10;
        int n = i++%5;
        System.out.println("i=" +i + ", n=" + n);
    }


    public static void main(String[] args) {
        ArithmeticOperators arithmeticOperators = new ArithmeticOperators();
        arithmeticOperators.iAfterAdd();
    }
}
