package org.devon.algorithms.db;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/3/3 11:45 PM
 */
public class DynamicProgramming {

    public static int[] countBits(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList());
        for (int num : nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            for (List<Integer> result : results) {
                List<Integer> subset = new ArrayList<>(result);
                subset.add(num);
                subsets.add(subset);
            }
            results.addAll(subsets);
        }
        return results;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            while (!d.isEmpty() && nums[i % n] > nums[d.peekLast()]) {
                int u = d.pollLast();
                ans[u] = nums[i % n];
            }
            d.addLast(i % n);
        }
        return ans;
    }

    /**
     * 总数为num元,需要最少多少枚conis中的硬币组成
     *
     * @param conis
     * @param num
     * @return
     */
    public static int coinChange(int conis[], int num) {
        int n = conis.length;
        int[] f = new int[num + 1];

        f[0] = 0;
        //f[1],f[2],f[3] .... f[n]
        for (int i = 1; i <= num; i++) {
            f[i] = Integer.MAX_VALUE;
            //last coin =coin[j]
            //f[i]= min{ f[i-coin[0]]+1,..., f[i-coin[n-1]]+1 }
            for (int j = 0; j < n; j++) {
                if (i >= conis[j] && f[i - conis[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - conis[j]] + 1, f[i]);
                }
            }
        }
        if (f[num] == Integer.MAX_VALUE) {
            f[num] = -1;
        }

        return f[num];

    }

    /**
     * 按摩师间隔预约 最长可预约多长时间
     *
     * @param nums
     * @return
     */
    public static int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        for (int i = 2; i < len; i++) {
            if (i == 2) {
                nums[i] = nums[i] + nums[i - 2];
            } else {
                nums[i] = nums[i] + Math.max(nums[i - 2], nums[i - 3]);
            }
        }
        return nums[len - 1] >= nums[len - 2] ? nums[len - 1] : nums[len - 2];
    }


    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static int maxEnvelopes(int[][] envelopes) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) {
            secondDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(secondDim);
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max, tempMin = min;
            max = Math.max(Math.max(nums[i], tempMax * nums[i]), tempMin * nums[i]);
            min = Math.min(Math.min(nums[i], tempMin * nums[i]), tempMax * nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }


    public int rob(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];

        for (int i = 2; i < nums.length; i++) {
            if (i == 2) {
                nums[i] = nums[i] + nums[i - 2];
            } else {
                nums[i] = nums[i] + Math.max(nums[i - 2], nums[i - 3]);
            }
        }

        return nums[len - 1] > nums[len - 2] ? nums[len - 1] : nums[len - 2];
    }



    public static void main(String[] args) {
        maxProduct(new int[]{-4, -3, -2});
        // maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
        //  massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3});
        //  minCoins(27);
    }


}
