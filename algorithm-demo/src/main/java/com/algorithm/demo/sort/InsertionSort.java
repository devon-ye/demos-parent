package com.algorithm.demo.sort;

public class InsertionSort {
    /**
     * 无序数组插入排序
     * 1.将数组分为有序和无序两部分（即第一个元素为有序数部分，第2到n为无序数组）
     * 2.外层循环拿取插入元素key
     * 3.获取待比计较下标j与插入元素key对比进入内循环
     * 4.如果插入元素key小于待比较的有序元素arry[j]，则待比较元素整体后移一位
     * 5.直到插入元素key比待比较元素小为止,跳出内部循环
     * 6.插入元素插入该插入的位置
     * 7.外层循环移位取出下一个插入元素key，重复步骤3、4、5、6
     * @param array
     * @return
     */
    public static int[] insert(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 1, length = array.length; i < length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j > -1 && key < array[j]) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;
        }

        return array;
    }


    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 4, 8, 0, 1, 3, 5, 7};
        InsertionSort.insert(array);
        int[] array2 = new int[]{1, 2, 3, 5, 0, 1, 3, 5, 7};
        InsertionSort.insert(array2);
    }

}