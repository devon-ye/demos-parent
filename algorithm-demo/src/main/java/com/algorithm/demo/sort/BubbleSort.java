package com.algorithm.demo.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:29
 * @since 1.0.0
 */
public class BubbleSort implements SortedAlgorithms {

    public static int[] bubbleSort(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0, length = array.length - 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }

        }
        return array;
    }
}
