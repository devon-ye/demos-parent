package org.devon.algorithm.data.structure.linked;

/**
 * @author dewen.ye
 * @date 2019/2/15 00:45
 */
public class DoubleCircularLinkedList<E> implements Linked<E> {

    @Override
    public boolean addFirst(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public boolean addLast(E e) {
        return false;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean clear() {
        return false;
    }

    private static class Node<E>{
        /**
         * prev node point
         */
        Node prev;
        /**
         * current node data
         */
        E data;
        /**
         * next node point
         */
        Node next;

        Node(Node prev, E data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}
