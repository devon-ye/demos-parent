package org.devon.algorithm.demo.data.structure.linked;

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
}
