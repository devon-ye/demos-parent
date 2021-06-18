package org.devon.algorithms.leetcode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class ArraysAllTest {

    private ArraysAll arraysAll = new ArraysAll();


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void removeDuplicatesSortedArray() {
        int[] a = {0, 0, 1, 2, 3, 3, 3, 4};
        Assert.assertEquals(5, ArraysAll.removeDuplicatesSortedArray(a));

        int[] b = {0, 1, 1, 2, 3, 3, 3, 4};
        Assert.assertEquals(5,ArraysAll.removeDuplicatesSortedArray(b));
    }


    @Test
    public void testMaxArea() {
        Assert.assertEquals(49, arraysAll.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    public void singleNumber() {
        Assert.assertEquals(49, arraysAll.singleNumber(new int[]{1, 8, 7, 2, 49, 2, 8, 1, 7}));
    }

    @Test
    public void merge() {
        //     int[][] result0= arraysAll.merge(new int[][]{{}});


        //   int[][] result1= arraysAll.merge(new int[][]{{1, 3}});

        //   int[][] result2= arraysAll.merge(new int[][]{{1, 3}, {2,3}});

        //    int[][] result3= arraysAll.merge(new int[][]{{1, 3}, {1,3},{8,9}});
        //[[2,3],[5,5],[2,2],[3,4],[3,4]]
        int[][] reeee = arraysAll.merge(new int[][]{{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}});
        int[][] result21 = arraysAll.merge(new int[][]{{1, 4}, {1, 4}});

        int[][] result4 = arraysAll.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.printf("result" + Arrays.toString(result4));

    }

    @Test
    public void search() {
        arraysAll.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }

    @Test
    public void coinChange() {
        arraysAll.coinChange(new int[]{2, 5, 7}, 7);

    }


    @Test
    public void maxIceCream() {
        arraysAll.maxIceCream(new int[]{1, 2, 3,4,1}, 7);

    }

    @Test
    public void removeElement() {
        int[] b = {0, 1, 1, 2, 3, 3, 3, 4};
        Assert.assertEquals(5,ArraysAll.removeElement(b, 3));
    }

    @Test
    public void findMedianSortedArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        Assert.assertEquals(2.0D,ArraysAll.findMedianSortedArrays(nums1, nums2),0);
    }

    @Test
    public void searchInsert() {
        int[] nums1 = {1,2,5,7,9};
        Assert.assertEquals(2,ArraysAll.searchInsert(nums1, 4));
    }
}
