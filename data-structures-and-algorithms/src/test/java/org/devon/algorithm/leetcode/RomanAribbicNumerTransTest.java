package org.devon.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/1/12 15:20
 */
public class RomanAribbicNumerTransTest {

    @Test
    public void testRomanToInt() {
        Assert.assertEquals(RomanAribbicNumerTrans.romanToInt("MCMLXXXIV"),1984);
        Assert.assertEquals(RomanAribbicNumerTrans.romanToInt("MCMLXXVI"),1976);
    }
}