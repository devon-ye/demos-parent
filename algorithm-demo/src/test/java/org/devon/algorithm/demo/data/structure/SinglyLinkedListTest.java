package org.devon.algorithm.demo.data.structure;

import org.devon.algorithm.demo.data.structure.linked.SinglyLinkedList;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dewen.ye
 * @description
 * @date 2019/1/26 04:10
 * @since ${project.version}
 */
public class SinglyLinkedListTest {

    SinglyLinkedList<Long> singlyLinkedList;

    @Before
    public void setUp() throws Exception {
        singlyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    public void addFirst() {

        for (int i = 0; i < 50; i++) {
            singlyLinkedList.addFirst(Long.valueOf(i));
        }
    }

    @Test
    public void removeFirst() {
        for (int i = 0; i < 40; i++) {
            singlyLinkedList.addFirst(Long.valueOf(i));
        }
    }

    @Test
    public void addLast() {
        for (int i = 0; i < 60; i++) {
            singlyLinkedList.addFirst(Long.valueOf(i));
        }
    }

    @Test
    public void removeLast() {
        for (int i = 0; i < 30; i++) {
            singlyLinkedList.addFirst(Long.valueOf(i));
        }
    }

    @Test
    public void isEmpty() {
        singlyLinkedList.isEmpty();
    }

    @Test
    public void size() {
        singlyLinkedList.size();
    }
}