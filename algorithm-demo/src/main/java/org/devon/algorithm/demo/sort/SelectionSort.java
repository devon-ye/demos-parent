package org.devon.algorithm.demo.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018.06.27 20:32:00
 * @since
 */
public class SelectionSort extends AbstractSort implements Sort {

    @Override
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
