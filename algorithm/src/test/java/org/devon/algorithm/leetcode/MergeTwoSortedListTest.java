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
        MergeTwoSortedList.mergeTwoList(node1, node4);
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
        MergeTwoSortedList.removeNthFromEnd(node1, 2);

    }

    @Test
    public void removeNthFromEnd2() {
        //case 2
        ListNode node = new ListNode(1);
        MergeTwoSortedList.removeNthFromEnd2(node, 1);
    }

    @Test
    public void mergeKLists1() {
        //case 1
        ListNode node1 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(7);
        ListNode node14 = new ListNode(9);
        node1.next = node12;
        node12.next = node13;
        node13.next = node14;


        ListNode node2 = new ListNode(3);


        ListNode node3 = new ListNode(2);
        ListNode node31 = new ListNode(5);
        ListNode node32 = new ListNode(8);
        ListNode node33 = new ListNode(9);
        node3.next = node31;
        node31.next = node32;
        node32.next = node33;

        ListNode node4 = new ListNode(7);
        ListNode node41 = new ListNode(8);
        ListNode node42 = new ListNode(18);
        ListNode node43 = new ListNode(30);
        node4.next = node41;
        node41.next = node42;
        node42.next = node43;



        ListNode[] lists = new ListNode[4];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;
        lists[3] = node4;

        MergeTwoSortedList.mergeKLists(lists);
    }

    @Test
    public void mergeKLists2() {
        //case 1
        ListNode node1 = new ListNode(2);
        ListNode node2 = null;
        ListNode node3 = new ListNode(-1);

        ListNode[] lists = new ListNode[3];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;

        MergeTwoSortedList.mergeKLists(lists);
    }


}