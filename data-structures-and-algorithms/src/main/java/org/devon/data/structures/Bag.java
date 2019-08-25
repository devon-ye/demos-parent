package org.devon.data.structures;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dewen.ye
 * @description
 * @date 2019/1/12 11:31
 */
public class Bag<I> implements Iterable<I> {
    private I i;
    private int size;

    public Bag() {

    }

    public void add(I i) {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
             return size;
    }


    @Override
    public Iterator<I> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super I> action) {

    }

    @Override
    public Spliterator<I> spliterator() {
        return null;
    }
}
