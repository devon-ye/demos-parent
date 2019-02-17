package com.switchs.demo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dewen.ye
 * @date 2019/2/17 14:55
 */
public class NumberTransformChineseNumberTest {

    @Test
    public void moneyValueTransformChar() {
        long value = 1731312312;
        NumberTransformChineseNumber.moneyValueTransformChar(value);
    }
}