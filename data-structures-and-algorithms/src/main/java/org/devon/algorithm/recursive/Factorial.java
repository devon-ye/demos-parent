package org.devon.algorithm.recursive;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Factorial {
    private static Logger log = LoggerFactory.getLogger(Factorial.class);
    public int factorial(int n) {
        if(n==0) {
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }

    public int factorialAge(int n) {
        if(n <= 0) {
            return 0;
        }else if( n == 1) {
            return 10;
        }else {
            return 2+ factorial(n-1);
        }
    }

}
