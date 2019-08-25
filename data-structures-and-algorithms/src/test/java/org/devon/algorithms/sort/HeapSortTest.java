package org.devon.algorithms.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Devonmusa
 * @date 2019/8/17 17:31
 * @since
 */
public class HeapSortTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sort() {
        HeapSort.sort(new Integer[]{1,23,45,2,6,78,12,8,4});
    }
}