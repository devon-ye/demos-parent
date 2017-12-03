package com.algorithm.recursion;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Factorial {

    public int factorial(int n) {
        if(n==0) {
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }


    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int num= factorial.factorial(5);
        System.out.println(num);

    }
}
