package org.devon.algorithm.data.structure.linked;

/**
 * @author dewen.ye
 * @date 2019/3/23 11:04
 */
public class FastSlowPointer<E> {
    private transient Node<E> head;

    public FastSlowPointer() {
        head = new Node<E>(null, this.head);
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
