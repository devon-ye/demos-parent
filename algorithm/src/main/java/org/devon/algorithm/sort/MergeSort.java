package org.devon.algorithm.sort;

/**
 * @author devonmusa
 */
public class MergeSort extends AbstractSort implements Sort {


    public static <T> T[] sort(T[] array, int low, int high) {

        if (low == high) {
            T[] arr = (T[]) newTypeTArray(array.getClass(), 1);
            arr[0] = array[low];
            return arr;
        }

        int mid = low + (high - low) / 2;

        T[] leftArray = sort(array, low, mid);
        T[] rightArray = sort(array, mid + 1, high);

        T[] newArray = (T[]) newTypeTArray(array.getClass(), (leftArray.length + rightArray.length));

        int m = 0, i = 0, j = 0;
        while (i < leftArray.length && j < rightArray.length) {
            newArray[m++] = less(leftArray[i], rightArray[j]) ? leftArray[i++] : rightArray[j++];
        }

        while (i < leftArray.length) {
            newArray[m++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            newArray[m++] = rightArray[j++];
        }
        return newArray;
    }



}
