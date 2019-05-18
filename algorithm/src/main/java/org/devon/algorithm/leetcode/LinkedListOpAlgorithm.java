package org.devon.algorithm.leetcode;

public class LinkedListOpAlgorithm {

    public static ListNode findMiddleNode(ListNode head){
        ListNode  fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
