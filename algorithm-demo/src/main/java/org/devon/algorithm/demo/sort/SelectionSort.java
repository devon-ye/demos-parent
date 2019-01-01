package org.devon.algorithm.demo.sort;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018.06.27 20:32:00
 * @since
 */
public class SelectionSort implements SortedAlgorithms{

    public static int[] sort(int[] array){
        if(array == null){

            return array;
        }


        for (int i = 0, len =array.length; i < len ; i++) {
            int maxIndex = i;

            for (int j = i+1; j < len; j++) {
                if(array[j] > array[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
        return  array;
    }


}
