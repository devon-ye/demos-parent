package org.devon.algorithm.leetcode;

import org.devon.algorithms.leetcode.LinkedListOpAlgorithm;
import org.devon.algorithms.leetcode.ListNode;
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(3, LinkedListOpAlgorithm.findMiddleNode(node1).val);
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

    @Test
    public void deleteDuplicates() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node31 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node41 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node31;
        node31.next = node4;
        node4.next = node41;
        node41.next = node5;
        LinkedListOpAlgorithm.deleteDuplicates(node1);
    }

    @Test
    public void partition() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node31 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node41 = new ListNode(2);
      //  ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node31;
        node31.next = node4;
        node4.next = node41;
      //  node41.next = node5;
        LinkedListOpAlgorithm.partition(node1,3);
    }
}