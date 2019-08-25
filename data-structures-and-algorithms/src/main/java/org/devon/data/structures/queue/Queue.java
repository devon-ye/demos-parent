package org.devon.data.structures.queue;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dewen.ye
 * @date 2019/1/12 11:36
 */
public class Queue<Item> implements Iterable<Item> {








    private Item item;

    private int size;

    public Queue() {
    }

    public void enqueue(Item item) {

    }

    public Item dequeue(Item item) {
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Item> action) {

    }

    @Override
    public Spliterator<Item> spliterator() {
        return null;
    }
}
