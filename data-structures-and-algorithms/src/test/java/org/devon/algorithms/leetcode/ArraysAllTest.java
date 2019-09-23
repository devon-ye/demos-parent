package org.devon.algorithms.leetcode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class ArraysAllTest {



    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void removeDuplicatesSortedArray() {
    }

    @Test
    public void removeElement() {
    }

    @Test
    public void findMedianSortedArrays() {
    }

    @Test
    public void searchInsert() {
    }

    @Test
    public void testMaxArea() {
        ArraysAll arraysAll = new ArraysAll();
        Assert.assertEquals(49,arraysAll.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    public void singleNumber() {
        ArraysAll arraysAll = new ArraysAll();
        Assert.assertEquals(49,arraysAll.singleNumber(new int[]{1, 8, 7,2, 49, 2, 8, 1, 7}));
    }
}
