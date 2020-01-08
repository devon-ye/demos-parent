package org.devon.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ParenthesesValid {
    private Map<Character, Character> mapping = new HashMap<>();

    public ParenthesesValid() {
        mapping.put(']', '[');
        mapping.put(')', '(');
        mapping.put('}', '{');
    }

    public boolean isValid(String s) {


        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (this.mapping.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.mapping.get(c)) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();

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
}
