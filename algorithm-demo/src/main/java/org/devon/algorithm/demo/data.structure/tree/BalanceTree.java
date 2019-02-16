package org.devon.algorithm.demo.data.structure.tree;

/**
 *  balance tree
 * @author devonmusa
 * @datetime 2018/6/5 17:01
 * @since 1.0.0
 */
public class BalanceTree<K extends Comparable<K>,V> {

   private static  int childSize = 6;

    private static class Node{
        private long key;
        private Entry[] children=new Entry[childSize];
        private Node next;
    }

    private static class Entry{
        private Comparable K;
        private Object V;
        private Node next;

        public Entry(Comparable k, Object v, Node next) {
            K = k;
            V = v;
            this.next = next;
        }
    }

}
