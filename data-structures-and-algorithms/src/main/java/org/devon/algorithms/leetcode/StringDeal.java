package org.devon.algorithms.leetcode;

import java.util.*;

/**
 * @author devon
 * @date 2019/1/15 23:40
 */
public class StringDeal {


    public String longestCommonPrefix(String[] strs) {
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

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
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


    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<String>();
        if (digits.length() == 0) return answer;
        int num = digits.length();
        backtrack(answer, digits, "", num);
        return answer;
    }

    //结果集， 选择列表， 决策路径
    public static String backtrack(List<String> answer, String digits, String track, int num) {
        if (track.length() == num) {
            answer.add(track);
            return track.substring(0, track.length() - 1);
        } else {
            String choiceLists = digits.substring(0, 1);
            String choiceList = phone.get(choiceLists);
            //n叉树遍历
            for (int i = 0; i < choiceList.length(); i++) {
                track += "" + choiceList.charAt(i);
                //在递归之前track的值已经改变了，因此会影响后面的结果。
                track = backtrack(answer, digits.substring(1), track, num);
            }
        }
        return track.length() == 0 ? "" : track.substring(0, track.length() - 1);
    }


    public static List<String> letterCombinationsDP(String digits) {

        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> li = new ArrayList<String>();
        if (digits.length() != 0) li.add("");

        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> temp = new ArrayList<String>();
            String chars = map[Integer.parseInt(digits.charAt(i) + "") - 2];

            for (int j = 0; j < chars.length(); j++) {
                for (int k = 0; k < li.size(); k++) {
                    temp.add(li.get(k) + chars.charAt(j));
                }
            }
            li = temp;
        }
        return li;
    }

    public static int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if (str.trim().length() == 0) return 0;

        //2. Remove Spaces
        while (str.charAt(index) == ' ' && index < str.length())
            index++;

        //3. Handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4. Convert number and avoid overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }

    public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }

        int result = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }
        return result;
    }


    public static int firstUniqChar2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result ^= s.indexOf(i);
        }
        char tempA = "s".charAt(0);
        return result;
    }

    private static final String PLUST_SYMBOL = "-";

    public static String sum(String a, String b) {

        if (a == null || a.trim().length() == 0) {
            return b;
        }

        if (b == null || b.trim().length() == 0) {
            return a;
        }

        if (a.indexOf(PLUST_SYMBOL) < 0 && b.indexOf(PLUST_SYMBOL) < 0) {
            // 1.两正数
            return add(a, b);
        } else if (a.indexOf(PLUST_SYMBOL) == 0 && b.indexOf(PLUST_SYMBOL) == 0) {
            // 2.俩负数
            return PLUST_SYMBOL + add(a.substring(1), b.substring(1));
        } else if (a.indexOf(PLUST_SYMBOL) == 0) {
            a = a.substring(1);
            if (a.compareTo(b) > 0) {
                return PLUST_SYMBOL + plus(a, b);
            } else {
                return plus(b, a);
            }
            // 3.正数除符号位>负数
            // 4.正数除符号位<负数
        } else if (b.indexOf(PLUST_SYMBOL) == 0) {
            b = b.substring(1);
            if (b.compareTo(a) > 0) {
                return PLUST_SYMBOL + plus(b, a);
            } else {
                return plus(a, b);
            }
        }
        return "0";
    }

    private static String add(String a, String b) {
        int firstLen = a.length();
        int secondLen = b.length();

        int index1 = firstLen - 1, index2 = secondLen - 1, pos = 0;
        StringBuilder result = new StringBuilder();
        while (index1 > -1 && index2 > -1) {

            int tempA = a.charAt(index1) - 48;
            int tempB = b.charAt(index2) - 48;

            int cur = tempA + tempB + pos;
            if (cur > 9 && cur > -1) {
                pos = cur / 10;
                cur = cur % 10;
            }
            index1--;
            index2--;
            result.append(cur);

        }
        //TODO 剩余高位未加的

        result = result.reverse();
        return result.toString();
    }

    private static String plus(String a, String b) {
        int firstLen = a.length();
        int secondLen = b.length();

        int index1 = firstLen - 1, index2 = secondLen - 1, pos = 0;
        StringBuilder result = new StringBuilder();
        while (index1 > -1 && index2 > -1) {
            int tempA = a.charAt(index1) - 48;
            int tempB = b.charAt(index2) - 48;
            int cur = 0;
            if (tempA - pos >= tempB) {
                cur = tempA - pos - tempB;
            } else {
                cur = tempA + 1 * 10 - tempB;
                pos = 1;
            }
            result.append(cur);
            index1--;
            index2--;
        }

        //TODO 剩余高位数的

        result = result.reverse();
        return result.toString();
    }


    public static boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (startIndex <= endIndex) {
            if (!isNumberOrLetter(s.charAt(startIndex))) {
                startIndex++;
                continue;
            }

            if (!isNumberOrLetter(s.charAt(endIndex))) {
                endIndex--;
                continue;
            }

            char left = s.charAt(startIndex);
            char right = s.charAt(endIndex);

            if (left >= 'A' && left <= 'Z') {
                left = (char) (left + 32);
            }

            if (right >= 'A' && right <= 'Z') {
                right = (char) (right + 32);
            }

            if (left == right) {
                startIndex++;
                endIndex--;
            } else {
                return false;
            }
        }
        return true;

    }

    private static boolean isNumberOrLetter(char s) {
        if (s >= '0' && s <= '9' || (s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z')) {
            return true;
        } else {
            return false;
        }
    }


    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }


    public static void main(String[] args) {
        isPalindrome("aA");
        isPalindrome("Marge, let's \"[went].\" I await {news} telegram.");
        isPalindrome("race a car");
        isPalindrome("A man, a plan, a canal: Panama");
        char ch0 = '0';
        char ch9 = '9';
        char cha = 'a';
        char chA = 'A';
        char chz = 'z';
        char chZ = 'Z';
//        int tempA =  "123".charAt(0);
//
        int tempC = "123".charAt(2) - 48;
//        int s1=  Integer.valueOf(tempC);
//     //   char dd = tempC + tempA;
//
//        StringBuilder sb = new StringBuilder();
        String a = "11111111";
        String b = "-222222222222";
        String res = sum(a, b);

        int tempB = "123".lastIndexOf(0);
        firstUniqChar2("leetcode");
    }


}
