/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithms.leetcode;

import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/17 11:24
 */
public class RemoveRepeatableElementTest {
    int[] array = new int[]{4, 2, 4, 8, 0, 1, 0, 3, 5, 7};

    @Test
    public void removeDuplicates() {

        RemoveRepeatableElement.removeDuplicates(array);
    }
}