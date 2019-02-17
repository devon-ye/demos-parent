package org.devon.algorithm.demo.leetcode;

import java.util.*;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:42
 * @since 1.0.0
 */
public class SumCompute {

   // 借助辅助空间空间换时间

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

   //利用时间复杂度换空间
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
}
