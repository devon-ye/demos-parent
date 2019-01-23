package org.devon.algorithm.demo.sort;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/6/23 17:38
 * @since 1.0.0
 */
public class QuickSortTest {
    public static Integer[] array = new Integer[]{1,3,4,9,2,6,0,3,2,6,8};
    @Before
    void setUp() {
    }

    @After
    void tearDown() {

        System.out.println(array);
    }

    @Test
    void quickSort() {

        QuickSort.sort(array,0,array.length-1);
    }
}