package org.devon.algorithm.leetcode;

/**
 * @author dewen.ye
 * @date 2019/4/9 08:13
 */
public class MergeTwoSortedList {

    public static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode q = p;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return q.next;
    }

    //todo fix bug
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            size++;
            fast = fast.next;
        }

        int removeNodeIndex = (size - n) + 1;
        int index = 0;
        while (slow != null) {
            index++;
            if (removeNodeIndex - 1 == index) {
                ListNode r = slow.next.next;
                slow.next = r;
            }
            slow = slow.next;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
      /*  ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node4.next = node5;
        node5.next = node6;

        MergeTwoSortedList.mergeList(node1,node4);*/


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        MergeTwoSortedList.removeNthFromEnd(node1,2);




    }
}
