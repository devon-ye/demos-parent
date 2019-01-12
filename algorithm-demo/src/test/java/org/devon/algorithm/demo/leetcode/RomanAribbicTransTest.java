package org.devon.algorithm.demo.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dewen.ye
 * @date 2019/1/12 15:20
 */
public class RomanAribbicTransTest {

    @Test
    public void testRomanToInt() {
        Assert.assertEquals(RomanAribbicTrans.romanToInt("MCMLXXXIV"),1984);
        Assert.assertEquals(RomanAribbicTrans.romanToInt("MCMLXXVI"),1976);
    }
}