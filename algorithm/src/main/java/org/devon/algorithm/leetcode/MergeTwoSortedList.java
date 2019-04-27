package org.devon.algorithm.leetcode;

/**
 * @author dewen.ye
 * @date 2019/4/9 08:13
 */
public class MergeTwoSortedList {

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
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


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast= dummy;
        ListNode slow = dummy;

        //快指针先走n+1
        for(int i = 1 ; i <= n+1; i++){
            fast = fast.next;
        }
        //快慢指针一块走 快指针到尾节点，满指针才到倒数n-1
        while (fast!= null) {
            fast= fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        //removeIndex = (L-N)+1 添加辅助节点后变为removeIndex =（L-N）
        length -= n;
        first = dummy;
        //用辅助节点从链表头部走到 removeIndex
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }


    public static ListNode mergeKLists(ListNode[] lists){
        ListNode dummy = lists[0];
        for(int i = 1; i < lists.length; i++){
            ListNode second = lists[i];
            dummy =mergeTwoList(dummy,second);
        }
        return dummy;
    }

}
