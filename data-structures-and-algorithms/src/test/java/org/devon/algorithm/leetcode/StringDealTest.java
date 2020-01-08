package org.devon.algorithm.leetcode;

import org.devon.algorithms.leetcode.StringDeal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author dewen.ye
 * @description
 * @date 2019/1/26 00:31
 * @since ${project.version}
 */
@BenchmarkMode(Mode.AverageTime) // 测试方法平均执行时间
@OutputTimeUnit(TimeUnit.MICROSECONDS) // 输出结果的时间粒度为微秒
@State(Scope.Thread)
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
            Assert.assertFalse(!"qewl".equals(stringDeal.longestCommonPrefix(arsg)));
        } catch (Exception e) {
        }
    }

    @Test
    public void longestCommonPrefixs() {
        String[] arsg = {"abddwqeeeebbc", "abddwqeeeb", "abddwqee", "abddwqe"};
        Assert.assertFalse(!"abddwqe".equals(stringDeal.longestCommonPrefix(arsg)));
    }

    @Test
    public void strStr() {
        Assert.assertEquals(4L,stringDeal.strStr("mississippi","issip"));
    }

    @Test
    public void lengthOfLongestSubstring1() {
        Assert.assertEquals(6,stringDeal.lengthOfLongestSubstring1("bdbsadlk"));
    }

    @Test
    public void lengthOfLongestSubstring2() {
        Assert.assertEquals(6,stringDeal.lengthOfLongestSubstring1("bdbsadlk"));

    }

    @Test
    public void lengthOfLongestSubstring3() {
        Assert.assertEquals(6,stringDeal.lengthOfLongestSubstring1("bdbsadlk"));

    }

    @Test
    @Benchmark
    public void lengthOfLongestSubstring11() {
        Assert.assertEquals("dabad",stringDeal.longestPalindrome("bcddabaderfs"));
    }
}