package org.devon.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author dewen.ye
 * @description
 * @date 2019/1/26 00:31
 * @since ${project.version}
 */
public class StringDealTest {
    private StringDeal stringDeal;

    @Before
    public void setUp() {
        stringDeal = new StringDeal();
    }

    @Test
    @Ignore
    public void longestCommonPrefix1() {
        String[] arsg = {"qewlqwoe", "qewljtuyet", "qewljeqweeqw", "qewlpppoo"};
        try {
            Assert.assertFalse(!"qewl".equals(stringDeal.longestCommonPrefix1(arsg)));
        } catch (Exception e) {
        }
    }

    @Test
    public void longestCommonPrefixs() {
        String[] arsg = {"abddwqeeeebbc", "abddwqeeeb", "abddwqee", "abddwqe"};
        Assert.assertFalse(!"abddwqe".equals(stringDeal.longestCommonPrefix2(arsg)));
    }

    @Test
    public void strStr() {
        Assert.assertEquals(4L,stringDeal.strStr("mississippi","issip"));
    }

    @Test
    public void lengthOfLongestSubstring1() {
        Assert.assertEquals(6,stringDeal.lengthOfLongestSubstring1("bdbsadlk"));
    }
}