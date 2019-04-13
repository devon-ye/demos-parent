package org.devon.algorithm.leetcode;

public class ArraysAll {

    public static int removeDuplicatesSortedArray(int[] nums) {
        int prev = 0;

        for (int i = 0; i < nums.length; i++) {
            prev = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (prev < nums[j]) {
                    break;
                } else if (prev == nums[j] && nums[j] < nums[j + 1]) {
                    nums[i + 1] = nums[j + 1];
                } else if (prev > nums[j]) {
                    nums[j] = 0;
                    return prev = i + 1;
                }
            }

        }
        return prev;
    }


    public static void main(String[] args) {
        int[] a = {0, 0, 1, 2, 3, 3, 3, 4};
        ArraysAll.removeDuplicatesSortedArray(a);
    }
}
