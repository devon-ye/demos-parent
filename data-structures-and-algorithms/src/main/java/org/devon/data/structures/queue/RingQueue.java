package org.devon.data.structures.queue;

public class RingQueue  implements Queue {

    private Object[] data;
    private int headIndex;
    private int tailIndex;

    RingQueue(int capacity){
        data = new Object[capacity];
    }


    @Override
    public void add(Object o) {

    }

    @Override
    public Object remove(Object o) {
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

    @Override
    public void clear() {

    }
}
