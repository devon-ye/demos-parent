package com.algorithm.demo.leetcode;

import java.util.*;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:42
 * @since 1.0.0
 */
public class SumCompute {



    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> integerMap = new HashMap<>(nums.length);
        for(int i=0,length=nums.length;i<length;i++){
            int complement = target - nums[i];
            if(integerMap.containsKey(complement)){
                return new int[]{integerMap.get(complement),i};
            }
            integerMap.put(nums[i],i);

        }
        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        SumCompute sumCompute = new SumCompute();
        int[] array = {0,4,3,0};
        //TODO FIX BUG
        sumCompute.twoSum(array,0);
    }
}
