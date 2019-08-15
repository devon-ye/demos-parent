package org.devon.algorithm.sort;

/**
 * @author devonmusa
 */
public class MergeSort extends AbstractSort implements Sort {


    public static Comparable[] mergeSort(Comparable[] array, int l, int h) {
        if (l == h) {
            return new Comparable[]{array[l]};
        }
        int mid = l + (h - l) / 2;
        Comparable[] leftArray = mergeSort(array, l, mid);
        Comparable[] rightArray = mergeSort(array, mid + 1, h);

        Comparable[] newArray = new Comparable[leftArray.length + rightArray.length];

        int m = 0, i = 0, j = 0;
        while (i < leftArray.length && j < rightArray.length) {
            newArray[m++] = less(leftArray[i], rightArray[j]) ? leftArray[i] : rightArray[j];
        }

        while (i < leftArray.length)
            newArray[m++] = leftArray[i];

        while (j < rightArray.length)
            newArray[m++] = rightArray[j];

        return newArray;
    }
}
