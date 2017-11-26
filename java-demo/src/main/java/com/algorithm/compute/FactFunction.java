
package com.algorithm.compute;

/**
 * Created by lenovo on 2017/11/18.
 */
public class FactFunction {

    public static int fact(int n) {
        int result = 1;
        if(n == 0 ) {
            return result;
        }else {
            result= n * fact(n-1);
        }

        return result;
    }


    public static void main(String[] args) {
            fact(3);
    }
}
