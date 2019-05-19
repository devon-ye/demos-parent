package org.devon.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListOpAlgorithmTest {

    @Test
    public void findMiddleNode() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Assert.assertEquals(3,LinkedListOpAlgorithm.findMiddleNode(node1).val);
    }

    @Test
    public void hasCycle1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        Assert.assertTrue(LinkedListOpAlgorithm.hasCycle1(node1));
    }

    @Test
    public void reverseList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Assert.assertEquals(4,LinkedListOpAlgorithm.reverseList(node1).val);
    }

    @Test
    public void hasCycle() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        Assert.assertTrue(LinkedListOpAlgorithm.hasCycle1(node1));
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
        LinkedListOpAlgorithm.removeNthFromEnd(node1, 2);

    }

    @Test
    public void removeNthFromEnd2() {
        //case 2
        ListNode node = new ListNode(1);
        LinkedListOpAlgorithm.removeNthFromEnd2(node, 1);
    }

    @Test
    public void removeElements() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Assert.assertEquals(1,LinkedListOpAlgorithm.removeElements(node1,3).val);
    }

    @Test
    public void isPalindrome() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        Assert.assertTrue(!LinkedListOpAlgorithm.isPalindrome(node1));
    }
}