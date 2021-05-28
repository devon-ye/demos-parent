package org.devon.algorithms.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/3/21 1:17 PM
 */
public class LinkedListOpAlgorithmTest {

    private ListNode node;
    private  LinkedListOpAlgorithm linkedListOp = new LinkedListOpAlgorithm();

    @Before
    public void setup(){
        linkedListOp = new LinkedListOpAlgorithm();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node = node1;
    }

    @Test
    public void oddEvenList() {
        linkedListOp.oddEvenList(node);
    }

    @Test
    public void oddEvenList2() {
        linkedListOp.oddEvenList2(node);
    }
}