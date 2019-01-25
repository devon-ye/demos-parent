package org.devon.algorithm.demo.data.structure;

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
}
