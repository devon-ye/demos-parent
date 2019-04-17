package org.devon.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAllTest {

    @Test
    public void removeDuplicatesSortedArray() {
        int[] a = {0, 0, 1, 2, 3, 3, 3, 4};
        ArraysAll.removeDuplicatesSortedArray(a);
        int[]  b= {0, 1, 1, 2, 3, 3, 3, 4};
        ArraysAll.removeDuplicatesSortedArray(b);


    }

    @Test
    public void removeElement() {
        int[]  b= {0, 1, 1, 2, 3, 3, 3, 4};
        ArraysAll.removeElement(b,3);
    }
}