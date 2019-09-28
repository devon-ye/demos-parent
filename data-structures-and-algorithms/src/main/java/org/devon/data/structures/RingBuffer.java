package org.devon.data.structures;

import java.util.concurrent.atomic.AtomicInteger;

public class RingBuffer {

    private Object[] data;
    private int readIndex;
    private int writeIndex;
    private int capacity;
    private AtomicInteger count = new AtomicInteger();


    public RingBuffer(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public boolean write(Object element) {
        if (count.get() == capacity) {
            throw new RuntimeException(" RingBuffer is full");
        }
        count.getAndIncrement();
        if (writeIndex == capacity) {
            writeIndex %= capacity;
        }
        data[writeIndex] = element;
        return true;
    }


    public Object read() {
        if (count.get() == 0) {
            return null;
        }
        readIndex++;
        if (readIndex == capacity) {
            readIndex %= capacity;
        }
        count.getAndDecrement();
        return data[readIndex];
    }
}
