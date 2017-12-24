package com.algorithm.recursion;

/**
 * Created by lenovo on 2017/12/6.
 */
public class Ackerman {

    public int acker(int m,int n){

        if(m==0){
            return n+1;
        }
        if(n==0){
            return acker(m-1,1);
        }
       return acker(m-1,acker(m,n-1));

    }
}
