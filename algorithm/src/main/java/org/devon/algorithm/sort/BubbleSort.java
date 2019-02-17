package org.devon.algorithm.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/4 23:29
 * @since 1.0.0
 */
public class BubbleSort extends AbstractSort implements Sort {

    public static Comparable[] sort(Comparable[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0, length = array.length - 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (less(array[j], array[j + 1])) {
                    exch(array, j + 1, j);
                }
            }
        }
        return array;
    }
}
