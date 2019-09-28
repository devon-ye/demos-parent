package org.devon.data.structures.linked;

/**
 * @author dewen.ye
 * @date 2019/2/12 23:31
 */
public class CircularLinkedListV2<E> implements Linked<E> {

    private int size = 0;
    private Node<E> node;
    private transient Node tail;

    public CircularLinkedListV2() {
    }

    /**
     *  insert element at the beginning of this list
     * @param e
     * @return {@Code  true}
     */
    @Override
    public boolean addFirst(E e) {
        ++size;
        final Node first = new Node<>(e);
        if (node == null) {
            tail = first;
            node = tail;
            node.next = tail;
        } else {
           Node node = tail;
            tail = first;
            tail.next = node;
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public E removeFirst() {
        if (node == null) {
            throw new NullPointerException("singlyLinkedList is null");
        }
        Node first = node;

        final E e = (E) first.e;
        final Node second = node.next;
        this.node = second;
        this.tail = second;
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
            last.next = tail;
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
        lastSecond.next = tail;
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

    @Override
    public boolean clear() {
        return false;
    }


    public static void main(String[] args) {
        Linked<Integer> loopLinkedList = new CircularLinkedListV2<>();
        for (int i = 0; i < 10; i++) {
            loopLinkedList.addFirst(i);
            loopLinkedList.addLast(i);
        }

        for (int j = 0; j < 8; j++) {
            loopLinkedList.removeLast();
            loopLinkedList.removeFirst();
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
