/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithm.leetcode;

import org.devon.algorithms.leetcode.Collections;
import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/16 23:46
 */
public class CollectionsTest {

    @Test
    public void mergeTwoLists() {
        Collections collections = new Collections();
        Collections.ListNode l1 = collections.buildLinkedNode(5);
        Collections.ListNode l2 = collections.buildLinkedNode(8);
        collections.mergeTwoLists(l1, l2);
    }
}