package org.devon.algorithm.leetcode;

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


}
