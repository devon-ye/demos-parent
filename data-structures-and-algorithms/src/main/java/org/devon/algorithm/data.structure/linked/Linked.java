package org.devon.algorithm.data.structure.linked;

/**
 * @author dewen.ye
 * @date 2019/1/21 00:19
 */
public interface Linked<E> {

     boolean  addFirst(E e);

     E removeFirst();

     boolean addLast(E e);

     E removeLast();

     boolean isEmpty();

     int size();

     boolean clear();
}
