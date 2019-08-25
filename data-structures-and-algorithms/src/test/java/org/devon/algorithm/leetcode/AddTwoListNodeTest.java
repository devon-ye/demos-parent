package org.devon.algorithm.leetcode;

import org.junit.Test;



public class AddTwoListNodeTest {

    @Test
    public void addTwoNumbers() {
        AddTwoListNode.ListNode l1 = new AddTwoListNode.ListNode(2);
        l1.next = new AddTwoListNode.ListNode(4);
        l1.next.next = new AddTwoListNode.ListNode(3);

        AddTwoListNode.ListNode l2 = new AddTwoListNode.ListNode(5);
        l2.next = new AddTwoListNode.ListNode(6);
        l2.next.next = new AddTwoListNode.ListNode(4);

        AddTwoListNode.addTwoNumbers(l1,l2);
    }
}