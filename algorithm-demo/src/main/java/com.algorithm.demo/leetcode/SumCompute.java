package java.com.algorithm.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:42
 * @since 1.0.0
 */
public class SumCompute {

    /**
     * 思想：比较数组两数组合的可能性大小和目标值拆分为两数可能性大小
     * 1.如果数组两数组合的数量小于目标值拆分组的可能性,即对数组两数求和跟目标值比较
     * 2.如果目标值拆分的组数小于数组组成可能性，即在数组中寻找目标值拆分后的值是否存在
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int targetCombinationSize = target / 2;

        int arrayCombinationSize = this.recursive(nums.length, 2);

        if (targetCombinationSize <= arrayCombinationSize) {
            Integer[] boxedArray = new Integer[nums.length];
            for(int i=0,length=nums.length;i<length;i++){
                boxedArray[i]=nums[i];
            }
            List<Integer> numList = new ArrayList<Integer>(Arrays.asList(boxedArray));
            for (int i = 0; i < targetCombinationSize; i++) {

                if (i == (target - i)) {
                    continue;
                }

                if (numList.contains(i) && numList.contains(target - i)) {
                    result[0] = i;
                    result[1] = target - i;
                }
            }

        } else {
            for (int j = 0; j < arrayCombinationSize; j++) {
                for (int k = j + 1; k < arrayCombinationSize; k++) {
                    if (nums[j]==(nums[k])) {
                        continue;
                    }
                    if ((nums[j] + nums[k]) == target) {
                        result[0] = nums[j];
                        result[1] = nums[k];
                    }
                }
            }
        }
        return result;

    }

    private int recursive(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (m < n) {
            return 0;
        }

        if (m == n) {
            return 1;
        }

        return recursive(m - 1, n) + recursive(m - 1, n - 1);
    }


    public static void main(String[] args) {
        SumCompute sumCompute = new SumCompute();
        int[] array = {3,2,4};
        sumCompute.twoSum(array,6);
    }
}
