package org.devon.algorithm.demo.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/23 17:38
 * @since 1.0.0
 */
class QuickSortTest {
    public static int[] array = new int[]{1,3,4,9,2,6,0,3,2,6,8};
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

        System.out.println(array);
    }

    @Test
    void quickSort() {

        QuickSort.quickSort(array,0,array.length-1);
    }
}