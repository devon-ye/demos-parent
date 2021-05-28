package org.devon.algorithms.db;

import org.junit.Test;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/3/3 11:45 PM
 */
public class BitSumTest {

    @Test
    public void countBits() {

        DynamicProgramming.countBits(8);
    }

    @Test
    public void subsets() {
        DynamicProgramming.subsets(new int[]{1,2,3});
    }
}