package org.devon.algorithms.recursion;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Fibonacci {


    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public int tribonacci1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return tribonacci1(n - 1) + tribonacci1(n - 2) + tribonacci1(n - 3);
        }
    }
}
