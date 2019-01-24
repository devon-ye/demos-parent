package org.devon.algorithm.demo.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/11 7:23
 * @since 1.0.0
 */
public class ShellSort {


    /**
     * 基于分治法思想，将数组跳跃式分为n个子数组插入排序，再次分为n/2个子数组...直到最后一个子数组
     * @param array
     * @return
     */
    public static int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        int j = 0;
        int temp = 0;
        for (int d = array.length / 2; d > 0; d /= 2) {
            for (int i = d; i < array.length; i++) {
                temp = array[i];
                for (j = i - d; j >= 0; j -= d) {
                    if (temp < array[j]) {
                        array[j + d] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + d] = temp;

            }


        }

        return array;

    }


    public static void main(String[] args) {
        int[] array = new int[]{6, 2, 1, 7, 9, 4, 3, 8, 5, 10};
        ShellSort.sort(array);
    }

}
