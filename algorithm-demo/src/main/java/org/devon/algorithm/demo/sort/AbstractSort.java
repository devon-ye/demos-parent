package org.devon.algorithm.demo.sort;

/**
 * @author dewen.ye
 * @date 2019/1/21 23:57
 */
public abstract class AbstractSort {

    public static void exch(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }




}
