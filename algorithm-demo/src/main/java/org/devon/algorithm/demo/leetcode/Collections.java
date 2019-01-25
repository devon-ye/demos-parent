package org.devon.algorithm.demo.leetcode;


/**
 * @author dewen.ye
 * @date 2019/1/26 00:42
 */
public class Collections {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode longList;
        ListNode shotList;
        if (l1.size() > l2.size()) {
            longList = l1;
            shotList = l2;
        } else {
            longList = l2;
            shotList = l1;
        }

        while (shotList.next != null) {
            int val = Integer.MAX_VALUE;
            while (longList.next != null) {
                if (longList.val == shotList.val) {
                    val = Integer.MAX_VALUE;
                    break;
                } else {
                    val = longList.val;
                }
            }
            if (val != Integer.MAX_VALUE) {
                ListNode suffix = shotList.next;
                shotList.next = new ListNode(val);
                shotList.next = suffix;
            }
        }
        return shotList;

    }

    public class ListNode {
        int val;
        private ListNode next;
        int modCount;


        ListNode(int x) {
            val = x;
        }

        public synchronized void add(ListNode ln) {
            modCount++;

            ListNode end = this;
            if (end.next == null) {
                end.next = ln;
            }

            while (end.next != null) {
                final ListNode temp = end.next;
                if (temp.next == null) {
                    temp.next = ln;
                    break;
                }
            }
        }

        public int size() {
            return modCount;
        }
    }


    private ListNode buildLinkedNode(int nodeSize) {
        ListNode l1 = new ListNode(0);
        int nodeCount = 1;
        while (nodeCount < nodeSize) {
            l1.add(new ListNode(nodeCount));
            ++nodeCount;
        }
        return l1;
    }

    public static void main(String[] args) {
        Collections collections = new Collections();
        ListNode l1 = collections.buildLinkedNode(5);
        ListNode l2 = collections.buildLinkedNode(8);
        collections.mergeTwoLists(l1, l2);
    }
}
