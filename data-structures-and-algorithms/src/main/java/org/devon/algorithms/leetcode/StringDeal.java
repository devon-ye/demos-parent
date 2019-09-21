package org.devon.algorithms.leetcode;

import java.util.*;

/**
 * @author devon
 * @date 2019/1/15 23:40
 */
public class StringDeal {

    public String longestCommonPrefix1(String[] strs) throws Exception {
        if (strs == null || strs.length == 0) {
            throw new Exception("There is no common prefix among the input strings");
        }
        String result = null;


        int size = strs.length;
        int itSize = size / 2;
        int lcp = 0;
        for (int i = 0; i < itSize; i++) {
            String leftStr = strs[i];
            String rightStr = strs[size - i - 1];
            int cl = leftStr.indexOf(rightStr);
            if (lcp == 0) {
                lcp = cl;
            }
        }

        return null;


    }


    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1, length = strs.length; i < length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        if ("".equals(haystack)) return -1;

        if (haystack.length() < needle.length()) return -1;

        int index = 0;
        int shortIndex = 0;
        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            char s = needle.charAt(shortIndex);
            if (s != c) {
                shortIndex = 0;
                index++;
                i = index - 1;
            } else {
                shortIndex++;
                if (shortIndex == needle.length()) {
                    return index;
                }
            }
        }

        return -1;

    }

    /**
     * approach 1:brute force
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * approach 2:sliding window
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int result = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                result = Math.max(result, end - start);
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return result;
    }

    /**
     * approach 3:sliding window Optimized
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }
            result = Math.max(result, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return result;
    }

    /**
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * <p>URL:https://leetcode.com/problems/regular-expression-matching/</p>
     *
     * @param string
     * @param pattern
     * @return
     */
    public boolean isMatch(String string, String pattern) {

        if (string == null || string.length() == 0) {
            return false;
        }

        if (pattern == null || pattern.length() == 0) {
            return false;
        }

        if (pattern.indexOf(".") > 0) {

        } else if (pattern.indexOf("*") > 0) {

        } else {
            int forCount = string.length() > pattern.length() ? pattern.length() : string.length();
            for (int i = 0; i < forCount; i++) {

            }
        }
        return false;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


}
