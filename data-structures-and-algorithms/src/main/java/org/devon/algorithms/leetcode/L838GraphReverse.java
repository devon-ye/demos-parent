package org.devon.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/7/17 22:06
 * @since 1.0.0
 */
public class L838GraphReverse {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) {
            return null;
        }

        for (int i = 0, h = A.length; i < h; i++) {
            int itCount = A[i].length / 2;
            int d = A[i].length;

            for (int j = 0; j < itCount; j++) {
                int temp = ~A[i][j];
                A[i][j] = ~A[i][d - 1 - j];
                A[i][d - 1 - j] = temp;

            }

            if(A[i].length / 2!=0){
                A[i][itCount] = ~A[i][itCount];
            }
        }

        return  A;
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> countSet= new HashSet<>(nums.length);
        for(int i= 0 ;i < nums.length;i++){
            if(countSet.contains(nums[i])){
                countSet.remove(nums[i]);
            }else{
                countSet.add(nums[i]);
            }

        }
        return countSet.iterator().next();
    }

    public static void main(String[] args) {
        L838GraphReverse.singleNumber(new int[]{4,1,2,1,2});
    }
}
