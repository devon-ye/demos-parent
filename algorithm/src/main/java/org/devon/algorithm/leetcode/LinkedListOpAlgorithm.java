package org.devon.algorithm.leetcode;

import java.util.*;

public class LinkedListOpAlgorithm {
    /**
     * complexity analysis
     * T(n) = n + n + n + n = 4n
     * <p>Time complexity</p> O(n)
     * <p>Space complexity</p> O(0)
     *
     * @param head
     * @return
     */
    public static ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * complexity analysis
     * T(n) = n + n + n + 2n +n =6n
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     *   if has cycle,  fast pointer already meeting slow pointer
     * complexity analysis
     * T(n) = n + n + n =3n
     * Time complexity: O(n)
     * S(n) = n
     * Space complexity: O(n)
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        Set<String> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head.toString());
            }
            head = head.next;
        }
        return false;
    }

    /**
     * complexity analysis
     * T(n) = n + n + n + n + n + n = 6n
     * Time complexity:O(n)
     * S(n) = 1
     * Space complexity:O(1)
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        ListNode result = new ListNode(0);
        ListNode dummy = null;
        while(head != null){
             //取出单节点
              dummy = head;
              head = head.next;
              dummy.next = null;

              dummy.next = result.next;
              result.next = dummy;
        }
        return result.next;
    }
}
