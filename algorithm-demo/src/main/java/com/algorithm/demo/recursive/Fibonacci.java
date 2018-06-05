package com.algorithm.demo.recursive;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Fibonacci {


    public int fibonacci(int n) {
        if(n==0) {
            return 0;
        }else if (n==1){
            return 1;
        }else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.fibonacci(5);
        System.out.println(result);
    }
}
