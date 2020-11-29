package org.devon.data.structures.linked;

/**
 * @author dewen.ye
 * @date 2019/3/23 11:04
 */
public class FastSlowPointer<E> {
    private transient Node<E> head;

    public FastSlowPointer() {
        head = new Node(0,null);
    }

    public E getBottomKthNode(int k) {
        if (head.next == null || k < 0) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        int i = k;

        for (; i > 0 && fast != null; i--) {
            fast = fast.next;
        }

        /**
         * linked size < k
         */
        if (i > 0) {
            return null;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return (E) slow.data;

    }

    public  boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    public  Node getCycleEntryNode(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
               break;
            }
        }
        Node entry = head;
        Node meet = fast;
        while (meet != fast){
            entry = entry.next;
            meet = meet.next;
        }
        return entry;
    }

    public Node detectCycle(Node head) {
        Node fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    public void add(E e) {
        final Node linked = head.next;
        Node element = new Node(e, linked);
        head.next = element;
    }


    class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
