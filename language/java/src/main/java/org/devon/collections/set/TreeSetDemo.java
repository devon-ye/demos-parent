package org.devon.collections.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lenovo on 2017/11/29.
 */
public class TreeSetDemo {

    private static Set<Object>  treeSet = new TreeSet <Object>();

    public static void main(String[] args) {
        treeSet.add("C");
        treeSet.add("C");
        treeSet.add("D");
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("E");
        System.out.println(treeSet);
    }
}
