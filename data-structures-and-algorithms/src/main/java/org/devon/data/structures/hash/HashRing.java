/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.data.structures.hash;

/**
 * @author dewen.ye
 * @date 2019/2/16 16:15
 */
public class HashRing {

	private static final int DEFAULT_CAPACITY=10000;

	private volatile int readIndex;
	private volatile int writeIndex;

     private Object[] data;

     private int size;
     private int capacity;



	public HashRing() {
		this(DEFAULT_CAPACITY);
	}

	public HashRing(int capacity){
		data =new Object[capacity];
		this.capacity = capacity;
	}

	public void write(Object obj){
		if(size > capacity) throw new RuntimeException("HashRing is full!");

		data[writeIndex] = obj;
		writeIndex++;
		if(writeIndex >= capacity) writeIndex = 0;
	}

	public Object read() {
		if(size ==0) throw new RuntimeException("HashRing is empty!");
		Object obj = data[readIndex];
		readIndex++;
		if(readIndex >= capacity) readIndex = 0;
		return obj;
	}
}
