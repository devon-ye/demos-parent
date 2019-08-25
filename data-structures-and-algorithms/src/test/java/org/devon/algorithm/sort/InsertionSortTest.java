/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author dewen.ye
 * @date 2019/2/17 11:03
 */
public class InsertionSortTest {
    Comparable[] array = new Comparable[]{4, 2, 4, 8, 0, 1, 3, 5, 7};
    Comparable[] array2 = new Comparable[]{1, 2, 3, 5, 0, 1, 3, 5, 7};
    @Test
    public void insert() {

        InsertionSort.sort(array);
        InsertionSort.sort(array2);
    }

    @Test
    public void exch() {
        InsertionSort.exch(array,3,7);
        Assert.assertEquals(new Comparable[]{4, 2, 4, 5, 0, 1, 3, 8, 7},array);
    }

    @Test
    public void less() {
        Assert.assertEquals(false,InsertionSort.less(23,0));
    }
}