package org.devon.algorithm.leetcode;

import java.util.HashMap;
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
}
