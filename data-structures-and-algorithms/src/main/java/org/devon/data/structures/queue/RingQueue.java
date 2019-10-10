package org.devon.data.structures.queue;

public class RingQueue implements Queue {

    private Object[] data;
    private int headIndex;
    private int tailIndex;
    private int capacity;
    private int count;

    RingQueue(int capacity) {
        this.capacity = capacity;
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
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        this.count = 0;
        this.headIndex = 0;
        this.tailIndex = 0;
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }
}

