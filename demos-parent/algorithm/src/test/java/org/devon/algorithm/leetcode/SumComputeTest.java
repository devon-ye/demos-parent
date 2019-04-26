/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithm.leetcode;

import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/17 11:21
 */
public class SumComputeTest {
    SumCompute sumCompute = new SumCompute();
    int[] array = {0, 4, 3, 0};

    @Test
    public void twoSum() {
        sumCompute.twoSum(array, 4);
    }

    @Test
    public void twoSum2() {
        sumCompute.twoSum2(array, 4);
    }
}