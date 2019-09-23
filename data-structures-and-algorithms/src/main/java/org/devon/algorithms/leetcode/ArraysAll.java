package org.devon.algorithms.leetcode;

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
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int medianLength = len / 2 + 1;
        int[] sortedArray = new int[medianLength];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < medianLength; i++) {
            boolean hasNum1 = false;
            boolean hasNum2 = false;
            if (index1 < nums1.length) {
                hasNum1 = true;
            }
            if (index2 < nums2.length) {
                hasNum2 = true;
            }
            if (hasNum1 && hasNum2) {
                if (nums1[index1] < nums2[index2]) {
                    sortedArray[i] = nums1[index1];
                    index1++;
                } else {
                    sortedArray[i] = nums2[index2];
                    index2++;
                }

            } else if (hasNum1) {
                sortedArray[i] = nums1[index1];
                index1++;
            } else {
                sortedArray[i] = nums2[index2];
                index2++;
            }
        }
        double median = 0;
        if (len % 2 == 0) {
            median = (sortedArray[medianLength - 2] + sortedArray[medianLength - 1]) / 2.0;
        } else {
            median = sortedArray[medianLength - 1];
        }
        return median;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * <p>URL:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/</p>
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }


}
