package org.devon.data.structures.queue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dewen.ye
 * @date 2019/1/12 11:36
 */
public interface Queue<E>  {


     void add(E e);

     E remove(E e) ;

     boolean isEmpty();

     boolean isFull();

     int size();

     void clear();

}
