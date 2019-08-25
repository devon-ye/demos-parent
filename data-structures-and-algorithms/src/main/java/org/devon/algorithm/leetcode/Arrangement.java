package org.devon.algorithm.leetcode;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/6 2:17
 * @since 1.0.0
 */
public class Arrangement {

    /**
     * N number not  repaete complete arrange
     * @param n
     * @return
     */
    public int allArrange(int n){
        if(n<=0){
            return 0;
        }
        return n * allArrange(n-1);
    }
}
