package org.devon.algorithm.demo.data.structure;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dewen.ye
 * @date 2019/1/12 11:31
 */
public class Stack<Item> implements Iterable<Item> {
    private Item item;
    private int size;

    public Stack() {

    }

    public void push(Item item) {

    }

    public Item pop() {
        //TODO
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
