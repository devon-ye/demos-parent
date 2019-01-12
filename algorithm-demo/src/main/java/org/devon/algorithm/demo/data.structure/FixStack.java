package org.devon.algorithm.demo.data.structure;

import java.io.Closeable;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dewen.ye
 * @date 2019/1/12 15:56
 */
public class FixStack<E> implements Iterable<E>, Closeable, java.io.Serializable {
    private E[] elementData;
    private int size;
    private int elementCount;

    public FixStack(int initialCapacity) {
        this.size = initialCapacity;
        elementData = (E[]) new Object[initialCapacity];
    }

    public void push(E e) {
        if (elementCount >= size) {
            throw new ArrayIndexOutOfBoundsException(elementCount + " >= " + size);
        }
        elementData[elementCount++] = e;
    }

    public E pop() {
        int index = --elementCount;
        if (index <= 0) {
            throw new EmptyStackException();
        }
        E e = (E) elementData[index];
        elementData[index] = null;
        return e;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public synchronized int size() {
        return elementCount;
    }



    @Override
    public Iterator<E> iterator() {
        //TODO
        return null;
    }


    @Override
    public void forEach(Consumer<? super E> action) {
        //TODO
    }

    @Override
    public Spliterator<E> spliterator() {
        //TODO
        return null;
    }

    public static void main(String[] args) {
        FixStack<Integer> integers = new FixStack<>(10);
        integers.push(1);
        integers.push(2);
        integers.push(3);
        integers.push(4);
        integers.push(5);
        integers.push(6);
        integers.push(7);
        integers.push(8);
        integers.push(9);
        integers.push(0);

        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();

    }

    @Override
    public void close() throws IOException {
        elementData=null;
    }

    private static final long serialVersionUID = -403306503202780380L;

}
