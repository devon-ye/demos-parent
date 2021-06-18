/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithms.search;

import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/17 11:10
 */
public class BinarySearchTest {

    @Test
    public void rank() {
        int[] array01 = new int[]{1,4,6,8,9,10,15,156,147};
        int position =  BinarySearch.search(array01,15);
    }
}