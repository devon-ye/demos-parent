package org.devon.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoSortedListTest {

    @Test
    public void mergeTwoList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node4.next = node5;
        node5.next = node6;
        MergeTwoSortedList.mergeTwoList(node1,node4);
    }

    @Test
    public void removeNthFromEnd() {
        //case 1
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

    @Test
    public void removeNthFromEnd2() {
        //case 2
        ListNode node = new ListNode(1);
        MergeTwoSortedList.removeNthFromEnd(node,1);
    }
}