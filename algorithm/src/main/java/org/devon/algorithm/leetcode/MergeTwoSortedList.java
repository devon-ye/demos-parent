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





    /**
     * This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly
     * <p>
     * Pair up \text{k}k lists and merge each pair.
     * <p>
     * After the first pairing, \text{k}k lists are merged into k/2k/2 lists with average 2N/k2N/k length, then k/4k/4, k/8k/8 and so on.
     * <p>
     * Repeat this procedure until we get the final sorted linked list.
     * <p>
     * Thus, we'll traverse almost NN nodes per pairing and merging, and repeat this procedure about \log_{2}{k}log
     * 2
     * ​
     * k times.
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        //数组中 分治链表的 间隔
        int interval = 1;
        /**
         * 外层循环控制: 链表融合次数，即跳表存储
         * 内层循环控制: 获取前后两个链表的合并，及合并后链表在数组中的位置
         */
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode dummy = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode second = lists[i];
            dummy = mergeTwoList(dummy, second);
        }
        return dummy;
    }


    public static  ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        ListNode next = null;
        while(head != null && head.next != null){

            dummy.next = head.next;

            head.next = null;
            //取出两个后面的指针
            next = dummy.next.next;

            dummy.next.next  = head;

            head = next;

            dummy = dummy.next.next;
        }
        if(head != null){
            dummy.next =head;
        }
        return result.next;
    }

    public static  ListNode reverseKGroup(ListNode head,int k) {
        ListNode result = new ListNode(0);
        ListNode dummy =result;
        ListNode start = null;
        ListNode end = null;
        int index = 0;
        while(head != null){
            index ++;

            if(index != k+1){
            //todo fix bug
                end =dummy;
                start = head;
                head  = head.next;
                start.next = dummy.next;
                dummy = start;
            }else{
                index = 0;
                start.next = head;
                dummy = dummy.next;
            }


        }

        return result.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = head;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return dummy;
    }

}
