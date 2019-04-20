package org.devon.algorithm.leetcode;

public class ArraysAll {
    // duble index  method
    public static int removeDuplicatesSortedArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0 ){
            return 0;
        }

        int index = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }

        }
        return index;

    }

}