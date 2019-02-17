/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithm.sort;

import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/17 11:09
 */
public class ShellSortTest {

    @Test
    public void sort() {
        int[] array = new int[]{6, 2, 1, 7, 9, 4, 3, 8, 5, 10};
        ShellSort.sort(array);
    }
}