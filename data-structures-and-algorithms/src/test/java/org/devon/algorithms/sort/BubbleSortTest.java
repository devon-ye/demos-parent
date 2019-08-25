/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithms.sort;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/17 10:53
 */
public class BubbleSortTest {
    public static Integer[] array = new Integer[]{1,3,4,9,2,6,0,3,2,6,8};

    @Before
    public void setUp() throws Exception {
        System.out.println("sorted before:");
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println("");
    }

    @Test
    public void sort() {
        BubbleSort.sort(array);
    }

    @Test
    public void exch() {
        BubbleSort.exch(array,1,9);
        Assert.assertEquals(new Integer[]{1,6,4,9,2,6,0,3,2,3,8},array);
    }

    @Test
    public void less() {
        Assert.assertEquals(true,BubbleSort.less(1,9));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("sorted after:");
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println("");
    }
}