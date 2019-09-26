package org.devon.algorithms.leetcode;

/**
 * @author Devonmusa
 * @date 2019/9/26 8:32
 * @since
 */
public class SlidingWindow {

    public static int maxSubArray(int[] nums) {
        int maxSum = 0;

        int length = nums.length;
        int right = length-1;
        for(int i = right;i > 0 ; i--){
            int left = 0;
            while(right < length){
                int currentSum = sumSubArray(nums,left,right);
                maxSum = currentSum > maxSum ? currentSum : maxSum;
                left++;
                right++;
            }
        }
        return maxSum;
    }

    private static int sumSubArray(int[] nums,int left,int right){
        int sum = 0;
        for(int j = left; j < right; j++){
            sum+=nums[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        SlidingWindow.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
