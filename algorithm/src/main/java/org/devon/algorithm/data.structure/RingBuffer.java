package org.devon.algorithm.data.structure;

public class RingBuffer {

    private Object[] data;
    private int readIndex;
    private int writeIndex;
    private int capacity;
    private volatile int count;


    public RingBuffer(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public boolean write(Object element) {
        if (count == capacity) {
            throw new RuntimeException(" RingBuffer is full");
        }
        count++;
        if (writeIndex == capacity) {
            writeIndex %= capacity;
        }
        data[writeIndex] = element;
        return true;
    }


    public Object read() {
        readIndex++;
        if (readIndex == capacity) {
            readIndex %= capacity;
        }
        count--;
        return data[readIndex];
    }
}
