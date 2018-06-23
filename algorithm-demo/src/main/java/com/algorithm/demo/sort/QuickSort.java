package com.algorithm.demo.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018.06.15 01:16
 * @since
 */
public class QuickSort implements SortedAlgorithms {


    public static int[] quickSort(int[] array, int left, int right) {
        if (array == null || left > right) {
            return null;
        }
        int position = partition(array, left, right);
        quickSort(array, left, position - 1);
        quickSort(array, position + 1, right);
        return array;
    }


    private static int partition(int[] array, int left, int right) {
        int i = left - 1;
        //以最右边元素为基准点
        int key = array[right];
        //开始以基准点为标准分割序列
        for (int j = left; j < right; j++) {
            if (array[j] < key) {
                i++;
                exchange(array, i, j);
            }
        }
        //将基准点放置到合适的位置
        exchange(array, i + 1, right);
        return i + 1;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }





    private static int partition2(int[] array,int left,int right){
        //最左边元素为基准点
        int key = array[left];

        while(left < right){
            //从最后找一个合适的值与前面的值交换
            while(left < right && array[right] >= key){
                right--;
            }
            exchange(array,left,right);
            //从前面找一个合适的值与后面的值交换
            while (left < right && array[left] <= key){
                left ++;
            }
            exchange(array,left,right);
        }
        return left;
    }

}
