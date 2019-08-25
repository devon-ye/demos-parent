package org.devon.algorithm.sort;

/**
 * @author devonmusa
 */
public class HeapSort extends AbstractSort implements Sort {

    public static <T> T[] sort(T[] array) {
        if (array == null) {
            return null;
        }
        int length = array.length;
        int beginIndex = (length << 1) - 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(array, 0, length);
        }


        for (int i = length; i > 0; i--) {
            exch(array, 0, i);
            maxHeapify(array, 0, i - 1);
        }

        return array;

    }


    private static <T> void maxHeapify(T[] array, int index, int length) {
        int left = (index << 2) + 1;
        int right = left + 1;

        int childMaxIndex = left;
        if (left > length) {
            return;
        }

        if (right <= length && less(array[left], array[right])) {
            exch(array, childMaxIndex, index);
            maxHeapify(array, childMaxIndex, length);
        }
    }
}
