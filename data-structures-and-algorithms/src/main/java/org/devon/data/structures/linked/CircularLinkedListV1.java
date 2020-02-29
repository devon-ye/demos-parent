package org.devon.data.structures.linked;

/**
 * @author dewen.ye
 * @date 2019/2/12 23:31
 */
public class CircularLinkedListV1<E> implements Linked<E> {

    private int size = 0;
    private Node<E> node;
    private transient Node head;

    public CircularLinkedListV1() {
    }

    public E get(int index) {
        Node node = head;
        for(int i=0;i<index;i++){
            if(node!=null){
                node = node.next;
            }else{
                return null;
            }
        }
        if(node!= null){
            return (E)node.val;
        }else{
            return null;
        }
    }

    @Override
    public boolean addFirst(E e) {
        ++size;

        final Node first = new Node<>(e);
        if (node == null) {
            head = first;
            node = head;
            node.next = head;
        } else {
            Node node = head;
            head = first;
            head.next = node;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if (node == null) {
            throw new NullPointerException("singlyLinkedList is null");
        }
        Node first = node;

        final E e = (E) first.val;
        final Node second = node.next;
        this.node = second;
        this.head = second;
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
            last.next = head;
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
        final E e = (E) lastSecond.next.val;
        lastSecond.next = head;
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
        Linked<Integer> loopLinkedList = new CircularLinkedListV1<>();
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
        E val;
        Node next;

        public Node(E val) {
            this.val = val;
        }

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
