package org.devon.algorithm.demo.leetcode;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/7 0:31
 * @since 1.0.0
 */
public class RemoveRepeateElement {
    /**
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int offset = 0;
        for (int i = 1, length = nums.length; i < length; i++) {
           if(nums[i]!=nums[offset]){
              offset++;
               nums[offset]=nums[i];
            }
        }

        return offset+1;
    }


}
