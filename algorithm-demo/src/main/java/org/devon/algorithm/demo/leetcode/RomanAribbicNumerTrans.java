package org.devon.algorithm.demo.leetcode;
/**
 * 罗马数字计数法
 * 基本字母  I(1) V(5) X(10) L(50)  C(100) D(500) M(1000)
 * C 拉丁字“centum”的头一个字母
 * M 是拉丁字“mille”的头一个字母
 * 1.相同数字连写，表示这些数字之合
 * 2.小数在大数右边表示的数字等于这些数字相加之和
 * 3.小数（I,X,C）在大数左边,所表示的数等于大数减小数之差
 * 4.在一个数字上面画一条横线，表示这个数字增加1000倍
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author dewen.ye
 * @date 2019/1/12 13:27
 */
public class RomanAribbicNumerTrans {
    private static Map<Character, Integer> romanIntMap = new HashMap<>();


    static {
        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);
    }

/**
 *
 * @param s
 * @return
 */
    /**
     * <p>罗马数字转为阿拉伯数字 </p>
     * <p>
     * 1.罗马串转字符数组
     * 2.遍历字符数组，将罗马基本数字对应阿拉伯数字取出
     * 3.阿拉伯数字求和
     * 4.只要出现相邻的右边的罗马字符大于左边的罗马字符的时候，
     * 上次求和值减去减去左边的罗马字符，右边罗马字符减左边罗马字符，再加上上次求和
     * 5.此处没考虑上划线罗马数字
     * </p>
     *
     * @param romanNumber 合法数字 没做校验
     * @return int 值
     */
    public static int romanToInt(String romanNumber) {
        char[] romanCharArry = romanNumber.toCharArray();
        int value = 0;
        int left = 0;
        for (int i = 0, len = romanCharArry.length; i < len; i++) {
            char rc = romanCharArry[i];
            int temp = romanIntMap.get(rc);
            if (temp > left) {
                value -= left;
                value += temp - left;
                left = temp;
            } else {
                value += temp;
                left = temp;
            }
        }
        return value;
    }

}
