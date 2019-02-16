package org.devon.algorithm.demo.data.structure.linked;

import org.devon.algorithm.demo.data.structure.linked.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author dewen.ye
 * @description
 * @date 2019/1/26 04:10
 * @since ${project.version}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SinglyLinkedListTest {

    static SinglyLinkedList<Long> singlyLinkedList;
    private int addFirstCount = 50;
    private int removeFirstCount = 40;
    private int addLastCount = 60;
    private int removeLastCount = 30;

    @BeforeClass
    public static void setUp() throws Exception {
        singlyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    public void test1AddFirst() {
        System.out.println("addFirst.hashCode:"+"addFirst".hashCode());
        for (int i = 0; i < addFirstCount; i++) {
            singlyLinkedList.addFirst(Long.valueOf(i));
        }
        Assert.assertEquals(addFirstCount, singlyLinkedList.size());
    }

    @Test
    public void test2RemoveFirst() {
        System.out.println("removeFirst.hashCode:"+"removeFirst".hashCode());
        for (int i = 0; i < removeFirstCount; i++) {
            singlyLinkedList.removeFirst();
        }
        Assert.assertEquals(addFirstCount - removeFirstCount, singlyLinkedList.size());
    }

    @Test
    public void test3AddLast() {
        System.out.println("addLast.hashCode:"+"addLast".hashCode());

        for (int i = 0; i < addLastCount; i++) {
            singlyLinkedList.addLast(Long.valueOf(i));
        }
        Assert.assertEquals((addFirstCount - removeFirstCount + addLastCount), singlyLinkedList.size());
    }

    @Test
    public void test4RemoveLast() {
        System.out.println("removeLast.hashCode:"+"removeLast".hashCode());

        for (int i = 0; i < removeLastCount; i++) {
            singlyLinkedList.removeLast();
        }
        Assert.assertEquals((addFirstCount - removeFirstCount + addLastCount - removeLastCount), singlyLinkedList.size());

    }

    @Test
    public void test5Clear() {
        Assert.assertEquals(true,singlyLinkedList.clear());
    }

    @Test
    public void test6IsEmpty() {
        Assert.assertEquals(true,singlyLinkedList.isEmpty());
    }

    @Test
    public void test7Size() {
        Assert.assertEquals(0,singlyLinkedList.size());
    }
}