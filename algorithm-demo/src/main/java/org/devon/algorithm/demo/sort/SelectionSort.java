package org.devon.algorithm.demo.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018.06.27 20:32:00
 * @since
 */
public class SelectionSort extends AbstractSort implements Sort {

    /**
     * <p>1.既每次遍历剩余数组找最小元素</p>
     * <p>2.交换最小元素与无序部分首个元素</p>
     * <p>特点：数据移动是最少的</p>
     * @param array
     * @return
     */
    public Comparable[] sort(Comparable[] array) {
        if (array == null) {
            return array;
        }
        for (int i = 0, len = array.length; i < len; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (less(array[i], array[maxIndex])) {
                    maxIndex = j;
                }
            }
            exch(array, i, maxIndex);
        }
        return array;
    }


}
