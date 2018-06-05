package com.algorithm.demo.leetcode;

import java.util.*;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:42
 * @since 1.0.0
 */
public class SumCompute {

    /**
     * 思想：比较数组两数组合的可能性大小和目标值拆分为两数可能性大小
     * 1.如果数组两数组合的数量小于目标值拆分组的可能性,即对数组两数求和跟目标值比较
     * 2.如果目标值拆分的组数小于数组组成可能性，即在数组中寻找目标值拆分后的值是否存在
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int targetCombinationSize = target / 2;
        Integer[] boxedArray = new Integer[nums.length];
        for(int i=0,length=nums.length;i<length;i++){
            boxedArray[i]=nums[i];
        }
        Set<Integer> integerSet = new HashSet();
        integerSet.addAll(Arrays.asList(boxedArray));
        int arrayCombinationSize = recursive(integerSet.size(),2);

        if (targetCombinationSize <= arrayCombinationSize) {

            List<Integer> numList = new ArrayList<Integer>(Arrays.asList(boxedArray));
            for (int i = 0; i < targetCombinationSize; i++) {

                if (numList.contains(i) && numList.contains(target - i)) {
                    result[0] = numList.indexOf(i);
                    result[1] =numList.indexOf(target - i);
                }
            }

        } else {
            for (int j = 0,length1=nums.length; j < length1; j++) {
                for (int k = j + 1; k < length1; k++) {

                    if ((nums[j] + nums[k]) == target) {
                        result[0] = j;
                        result[1] = k;
                    }
                }
            }
        }
        return result;

    }

    private int recursive(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (m < n) {
            return 0;
        }

        if(n==1){
            return m;
        }

        if (m == n) {
            return 1;
        }

        return recursive(m-1 , n) + recursive(m - 1, n - 1);
    }



    public static void main(String[] args) {
        SumCompute sumCompute = new SumCompute();
        int[] array = {0,4,3,0};
        //TODO FIX BUG
        sumCompute.twoSum(array,0);
    }
}
