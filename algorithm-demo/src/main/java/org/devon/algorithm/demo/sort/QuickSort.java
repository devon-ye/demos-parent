package org.devon.algorithm.demo.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018.06.15 01:16
 * @since
 */
public class QuickSort extends AbstractSort implements Sort {


    public static Comparable[] sort(Comparable[] array, int left, int right) {
        if (array == null || left > right) {
            return null;
        }
        int position = partition(array, left, right);
        sort(array, left, position - 1);
        sort(array, position + 1, right);
        return array;
    }


    private static int partition(Comparable[] array, int left, int right) {
        int i = left - 1;
        //以最右边元素为基准点
        Comparable key = array[right];
        //开始以基准点为标准分割序列
        for (int j = left; j < right; j++) {
            if (less(array[j], key)) {
                i++;
                exch(array, i, j);
            }
        }
        //将基准点放置到合适的位置
        exch(array, i + 1, right);
        return i + 1;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }


    private static int partition2(Comparable[] array, int left, int right) {
        //最左边元素为基准点
        Comparable key = array[left];

        while (left < right) {
            //从最后找一个合适的值与前面的值交换
            while (left < right && less(key, array[right])) {
                right--;
            }
            exch(array, left, right);
            //从前面找一个合适的值与后面的值交换
            while (left < right && less(array[left], key)) {
                left++;
            }
            exch(array, left, right);
        }
        return left;
    }

    public Comparable[] sort(Comparable[] array) {
        return new Comparable[0];
    }
}
