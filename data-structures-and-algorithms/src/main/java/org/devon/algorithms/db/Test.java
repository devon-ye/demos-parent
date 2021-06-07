package org.devon.algorithms.db;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/6/7 20:31
 */
public class Test {

    /**
     * 输入一个递增排序的数组和一个数字s,在数组中查找两个数，使得它们的和正好是s。
     *  如果有多对数字的和等于s,输出任意一对即可
     */

    public static int[] findNumbers(int array[] ,int target){

        if(array.length<2){
            return new int[2];
        }

        Map<Integer,Integer> cache = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
          int temp  = target-array[i];
            if(!cache.containsKey(array[i])){
                cache.put(temp,array[i]);
            }else {
                return new int[]{temp,array[i]};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
      int[] result =  findNumbers(new int[]{1,2,3,4,5,6,7,8,9,10},7);
        int[] results =  findNumbers(new int[]{1,3,6,8},10);

        System.out.printf(Arrays.toString(result));
    }
}
