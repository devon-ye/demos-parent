package org.devon.data.structures.linked;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/3/23 11:20
 */
public class FastSlowPointerTest {

    private static FastSlowPointer<Integer> fastSlowPointer = new FastSlowPointer<>();

    @Before
    public void setUp() {
        for (int i = 0; i < 30; i++) {
            fastSlowPointer.add(i);
        }
    }

    @Test
    public void getBottomKthNode() {
        int k = 23;
        Integer kValue = fastSlowPointer.getBottomKthNode(k);
        Assert.assertEquals((long) 22, (long) kValue);
    }
}