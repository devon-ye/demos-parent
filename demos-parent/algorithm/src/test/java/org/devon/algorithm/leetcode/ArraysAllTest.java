package org.devon.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAllTest {

    @Test
    public void removeDuplicatesSortedArray() {
        int[] a = {0, 0, 1, 2, 3, 3, 3, 4};
        Assert.assertEquals(5,ArraysAll.removeDuplicatesSortedArray(a));

        int[] b = {0, 1, 1, 2, 3, 3, 3, 4};
        Assert.assertEquals(5,ArraysAll.removeDuplicatesSortedArray(b));


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
        Assert.assertEquals(2,ArraysAll.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void searchInsert() {
        int[] nums1 = {1,2,5,7,9};
        Assert.assertEquals(2,ArraysAll.searchInsert(nums1, 4));
    }
}