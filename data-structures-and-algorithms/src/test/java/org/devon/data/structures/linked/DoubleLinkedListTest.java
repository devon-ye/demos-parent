/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.data.structures.linked;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author dewen.ye
 * @date 2019/2/16 17:42
 */
@Ignore
public class DoubleLinkedListTest implements LinkedListTest {
    private static DoubleLinkedList<Integer> doubleLinkedList;
    private Integer addFirstCount = 10;

    @Before
    public  void setUp() throws Exception {
        doubleLinkedList = new DoubleLinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1AddFirst() {
        for (int i = 0; i < addFirstCount; i++) {
            doubleLinkedList.addFirst(i);
            Assert.assertEquals(i + 1, doubleLinkedList.size());
        }
        Assert.assertEquals(java.util.Optional.of(0), doubleLinkedList.removeFirst());
        Assert.assertEquals(java.util.Optional.of(addFirstCount - 1), doubleLinkedList.removeLast());
    }

    @Test
    public void removeFirst() {

        addElement(10, doubleLinkedList);
        int elementTotalCount = doubleLinkedList.size();
        for (int i = 0; i < addFirstCount; i++) {
            doubleLinkedList.removeFirst();
            --elementTotalCount;
            Assert.assertEquals(elementTotalCount, doubleLinkedList.size());
        }
    }

    @Test
    public void addLast() {
        addElement(10, doubleLinkedList);
        int elementTotalCount = doubleLinkedList.size();
        for (int i = 0; i < addFirstCount; i++) {
            doubleLinkedList.addLast(i);
            ++elementTotalCount;
            Assert.assertEquals(elementTotalCount, doubleLinkedList.size());
        }
        Assert.assertEquals(java.util.Optional.of(0), doubleLinkedList.removeLast());
        Assert.assertEquals(java.util.Optional.of(addFirstCount - 1), doubleLinkedList.removeLast());
    }

    @Test
    public void removeLast() {
        addElement(10, doubleLinkedList);
        int elementTotalCount = doubleLinkedList.size();
        for (int i = 0; i < addFirstCount; i++) {
            doubleLinkedList.removeLast();
            --elementTotalCount;
            Assert.assertEquals(elementTotalCount, doubleLinkedList.size());
        }
    }

    @Test
    public void isEmpty() {
        addElement(50, doubleLinkedList);
        doubleLinkedList.clear();
        Assert.assertEquals(true, doubleLinkedList.isEmpty());
    }

    @Test
    public void size() {
        addElement(101, doubleLinkedList);
        Assert.assertEquals(101, doubleLinkedList.size());
    }

    @Test
    public void clear() {
        addElement(202, doubleLinkedList);
        Assert.assertEquals(true,doubleLinkedList.clear());
        Assert.assertEquals(0, doubleLinkedList.size());
    }
}