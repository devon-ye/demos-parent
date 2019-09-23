package org.devon.algorithms.leetcode;


/**
 * @author dewen.ye
 * @date 2019/1/26 00:42
 */
public class Collections {
    //TODO FIX BUG

    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode longList;
        ListNode shotList;
        if (l1.size() > l2.size()) {
            longList = l1;
            shotList = l2;
        } else {
            longList = l2;
            shotList = l1;

        }
        ListNode compareNode = shotList;
        while (compareNode.next != null) {

            while (longList.next != null) {
                if (longList.val <= compareNode.val) {
                    longList = longList.next;
                } else{
                  ListNode nextNode = compareNode.next;
                  if(nextNode.val > longList.val){
                      ListNode newLong = longList.next;
                      ListNode mergeNode = new ListNode(longList.val);
                      shotList.next = mergeNode;
                      mergeNode.next  = nextNode;
                      longList = newLong;
                  }else{
                      compareNode = compareNode.next;
                      break;
                  }
                }
            }
        }
        return shotList;

    }

    public class ListNode {
        int val;
        private ListNode next;
        int modCount;


        ListNode(int x) {
            val = x;
        }

        public synchronized void add(ListNode ln) {
            modCount++;
            if (this.next == null) {
                this.next = ln;
                return;
            }

            ListNode currentNode = this.next;
            while (currentNode != null) {
                if (currentNode.next == null) {
                    currentNode.next = ln;
                    break;
                }
               currentNode = currentNode.next;

            }
        }

        public int size() {
            return modCount;
        }
    }


    public ListNode buildLinkedNode(int nodeSize) {
        ListNode l1 = new ListNode(0);
        int nodeCount = 1;
        while (nodeCount < nodeSize) {
            l1.add(new ListNode(nodeCount));
            ++nodeCount;
        }
        return l1;
    }
}
