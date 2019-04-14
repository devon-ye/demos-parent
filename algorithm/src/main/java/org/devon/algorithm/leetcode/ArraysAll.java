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


    public static void main(String[] args) {
        int[] a = {0, 0, 1, 2, 3, 3, 3, 4};
        ArraysAll.removeDuplicatesSortedArray(a);
        int[]  b= {0, 1, 1, 2, 3, 3, 3, 4};
        ArraysAll.removeDuplicatesSortedArray(b);
    }
}
