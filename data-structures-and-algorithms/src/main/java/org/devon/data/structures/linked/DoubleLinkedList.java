package org.devon.data.structures.linked;

import java.io.Serializable;

/**
 * @author dewen.ye
 * @date 2019/2/16 16:01
 */
public class DoubleLinkedList<E> implements Linked<E> , Serializable {
    private static final long serialVersionUID = -3242939199260468022L;
    private transient int size = 0;
    private transient Node<E> first;
    private transient Node<E> last;



    public DoubleLinkedList() {
    }

    @Override
    public boolean addFirst(E e) {
        ++ size;
        final Node newNode = new Node(null, e, null);
        if (first == null || last == null) {
            last = first = newNode;
            first.next =last  ;
            last.prev = first;
        } else {
            final Node oldFirst = first;
            first = newNode;
            first.next = oldFirst;
            oldFirst.prev = first;

        }
        return true;
    }

    @Override
    public E removeFirst() {
        if (first == null || last == null) {
            throw new NullPointerException("Null DoubleLinkedList Exception");
        }
        --size;
        final Node newNode = first.next;
        final E e = first.data;
        if (newNode == null) {
            this.size = 0;
            this.first = null;
            this.last = null;
        } else {
            first = newNode;
        }
        return e;
    }

    @Override
    public boolean addLast(E e) {
        ++size;
        final  Node newNode= new Node(null,e,null);
        if(first == null || last == null){
            first = newNode;
            last = newNode;
        }else {
            final Node oldLast = last;
            last = newNode;
            oldLast.next = last;
            last.prev = oldLast;
        }
        return true;
    }

    @Override
    public E removeLast() {
        if (first == null || last == null) {
            throw new NullPointerException("Null DoubleLinkedList Exception");
        }
        --size;
        final Node newLast = last.prev;
        final E e = last.data;
        if (newLast == null) {
            this.size = 0;
            this.first = null;
            this.last = null;
        } else {
            last = newLast;
        }
        return e;
    }

    @Override
    public boolean isEmpty() {
        return (first==null && last == null && size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean clear() {
        --size;
        Node<E> currentNode = first;
        while (first != null){
            currentNode.prev = null;
            currentNode = currentNode.next;
            first = null;
            first = currentNode;
        }
        return true;
    }


    private static class Node<E> {
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
