package org.devon.algorithm.demo.data.structure.linked;


/**
 * single linked table
 *
 * @author dewen.ye
 * @date 2019/1/26 02:31
 */
public class SinglyLinkedList<E> implements Linked<E> {



    private int size = 0;
    private Node<E> node;

    public SinglyLinkedList() {
    }


    @Override
    public boolean addFirst(E e) {
        ++size;
        final Node first = new Node<>(e);
        if (node == null) {
            node = first;
        } else {
            first.next = node;
            node = first;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if (node == null) {
            throw new NullPointerException("singlyLinkedList is null");
        }
        Node first = node;
        final E e = (E) first.e;
        final Node second = node.next;
        this.node = second;
        --size;
        first = null;
        return e;
    }

    @Override
    public boolean addLast(E e) {
        final Node last = new Node(e);
        for (Node x = node; x != null; x = x.next) {
            if (x.next == null) {
                x.next = last;
                return true;
            }
        }
        // empty linked deal
        if (node == null) {
            node = last;
        }
        return false;
    }

    @Override
    public E removeLast() {
        Node lastSecond = null;
        for (Node x = node; x != null; x = x.next) {
            if (x.next != null) {
                lastSecond = x;
            }
        }
        if (lastSecond == null || lastSecond.next == null) {
            return null;
        }
        final E e = (E) lastSecond.next.e;
        lastSecond.next = null;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return (node == null || node.next == null);
    }

    @Override
    public int size() {
        return size;
    }


    public static void main(String[] args) {
        Linked<Integer> singlyLinkedList = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            singlyLinkedList.addFirst(i);
            singlyLinkedList.addLast(i);
        }

        for (int j = 0; j < 8; j++) {
            singlyLinkedList.removeLast();
            singlyLinkedList.removeFirst();
        }
    }


    public static class Node<E> {
        E e;
        Node next;

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }
}
