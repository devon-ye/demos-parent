package org.devon.algorithms.leetcode;


import com.oracle.javafx.jmx.json.impl.JSONMessages;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArraysAll {
    // duble index  method
    public static int removeDuplicatesSortedArray(int[] nums) {
        if (nums == null) {
            return -1;
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

    /**
     * 删除重复元素，及重复元素保留两个
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        //
        // Initialize the counter and the second pointer.
        //
        int j = 1, count = 1;

        //
        // Start from the second element of the array and process
        // elements one by one.
        //
        for (int i = 1; i < nums.length; i++) {

            //
            // If the current element is a duplicate, increment the count.
            //
            if (nums[i] == nums[i - 1]) {

                count++;

            } else {

                //
                // Reset the count since we encountered a different element
                // than the previous one.
                //
                count = 1;
            }

            //
            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "j" in the array
            //
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
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

    /**
     * <p> two sorted array median index = nums1.length+nums2.length/2+1,because two array have zero index</p>
     * <p> double index serial iterator double sorted index get medianLength elements</p>
     * <p> even get last double element  or olden  get last element</p>
     *
     * @param nums1
     * @param nums2
     * @return
     */
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


    /* <p>URL:https://leetcode-cn.com/problems/container-with-most-water/</p>
     *
     * @param height
     * @return
     */


    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int max = 0;
        int minHeight = 0;
        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                minHeight = height[leftIndex];
                max = Math.max(max, minHeight * (rightIndex - leftIndex));
                leftIndex++;
            } else {
                minHeight = height[rightIndex];
                max = Math.max(max, minHeight * (rightIndex - leftIndex));
                rightIndex--;
            }
        }
        return max;
    }

    /**
     * <p>URL:https://leetcode-cn.com/problems/single-number/</p>
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    /**
     * <p>URL:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/</p>
     *
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public List<List<Integer>> threeSum(int[] num) {

        Arrays.sort(num);

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < num.length - 2; i++) {

            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }

        }
        return res;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /***
     *  EXAMPLE -1 -1 -1 -1 -1 bug
     * @param nums
     * @return
     */
    public static int pivotIndexBUG(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = 0;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex < endIndex) {
            if (left == right && right != 0) {
                return startIndex + 1;
            } else if (left < right) {
                startIndex++;
                left += nums[startIndex];
            } else if (right < left) {
                endIndex--;
                right += nums[endIndex];
            } else {
                left += nums[startIndex];
                right += nums[endIndex];
            }

        }

        return -1;
    }

    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }

    public int dominantIndex(int[] nums) {
        if (nums.length < 1 || nums.length >= 50) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int maxNum = Integer.MIN_VALUE;
        int secondNum = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                secondNum = maxNum;
                maxNum = nums[i];
                index = i;
            } else {
                if (secondNum < nums[i]) {
                    secondNum = nums[i];
                }
            }
        }
        if (maxNum >= secondNum * 2) {
            return index;
        }
        return -1;

    }

    public static int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public static int[] plusOne(int[] digits) {
        if (digits == null) return null;

        int len = digits.length - 1;
        int pos = 0;
        for (int i = len; i > -1; i--) {
            if (i == len) {
                int result = 1 + digits[i];
                pos = result / 10;
                digits[i] = result % 10;
            } else {
                int result = pos + digits[i];
                pos = result / 10;
                digits[i] = result % 10;
            }

        }
        if (pos > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = pos;
            return result;
        } else {
            return digits;
        }
    }

    public static int[] plusOne2(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + 1;
            if (temp / 10 > 0) {
                digits[i] = temp % 10;
            } else {
                digits[i] = temp;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }

        int pos = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != 0) {
                nums[pos] = nums[index];
                if (pos != index) {
                    nums[index] = 0;
                }
                pos += 1;
            }
            index += 1;
        }

    }

    /**
     * 荷兰国旗问题
     * 用两个边界分割指针和一个偏移指针处理
     */
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int p0 = 0;
        int p1 = nums.length - 1;
        int curr = 0;
        while (curr <= p1) {
            if (nums[curr] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[curr];
                nums[curr] = temp;
                p0++;
                curr++;

            } else if (nums[curr] == 2) {
                int temp = nums[p1];
                nums[p1] = nums[curr];
                nums[curr] = temp;
                p1--;
            } else {
                curr++;
            }

        }
    }

    public static int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int maxIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[maxIndex] < nums[j]) {
                    maxIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
            if (i + 1 == k) {
                return nums[i];
            }
            maxIndex++;
        }
        return -1;

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{i, map.get(num)};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    public static boolean isValidSudoku(char[][] board) {
        byte[] row = new byte[10];
        byte[][] box = new byte[3][10];
        byte[][] col = new byte[10][10];

        //row iterator
        for (int i = 0; i < 9; i++) {
            //col iterator
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j]) continue;

                //row check
                int num = Character.getNumericValue(board[i][j]);
                byte rowTag = (byte) (i + 1);
                if (row[num] == rowTag) {
                    return false;
                } else {
                    row[num] = rowTag;
                }

                // box check
                byte boxTag = (byte) ((i / 3)*3 + j/3+1);
                if (box[j / 3][num] == boxTag) {
                    return false;
                } else {
                    box[j  / 3][num] = boxTag;
                }

                //col check
                byte colTag = (byte) (j + 1);
                if (col[j][num] == colTag) {
                    return false;
                } else {
                    col[j][num] = colTag;
                }

            }
        }

        return true;
    }


    public static void main(String[] args) {
        // ArraysAll.plusOne2(new int[]{9, 9, 9, 9});
        char[][] board = new char[9][9];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        board[0][4]='5';
        board[0][7]='1';
        board[1][1]='4';
        board[1][3]='3';
        board[2][5]='3';
        board[2][8]='1';
        board[3][0]='8';
        board[3][7]='2';
        board[4][2]='2';
        board[4][4]='7';
        board[5][1]='1';
        board[5][2]='5';
        board[6][5]='2';
        board[7][1]='2';
        board[7][3]='9';
        board[8][2]='4';
        isValidSudoku(board);



    }

}
