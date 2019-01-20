package org.devon.algorithm.demo.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author devon
 * @date 2019/1/15 23:40
 */
public class StringDeal {

    public String longestCommonPrefix(String[] strs) throws Exception {
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
            if(lcp==0){
                lcp = cl;
            }
        }

       return null;


    }


    public String longestCommonPrefixs(String[] strs) {
        if (strs.length == 0) {return "";}
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {return "";}
            }
        }
        return prefix;
    }
}
