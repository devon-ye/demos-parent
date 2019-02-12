package org.devon.algorithm.demo.data.structure;

import org.devon.algorithm.demo.data.structure.stack.FixStack;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import java.util.EmptyStackException;



/**
 * @author dewen.ye
 * @date 2019/1/12 16:39
 */
@FixMethodOrder(MethodSorters.JVM)
public class FixStackTest {

    static FixStack<Integer> integers = new FixStack<>(10);

    @Test
    public void testPush() {
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
        try {
            integers.push(8);
            integers.push(9);
            integers.push(0);
        } catch (Exception e) {
            if (e instanceof ArrayIndexOutOfBoundsException) {

            } else {
                throw e;
            }
        }
    }



    @Test
    public void testPop() {
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();
        integers.pop();

        try {
            integers.pop();
            integers.pop();
            integers.pop();
        } catch (Exception e) {
            if (e instanceof EmptyStackException) {
            } else {
                throw e;
            }
        }
    }


    @Test
    public void isEmpty() {
        if (integers.size() == 0) {
            Assert.assertFalse(!integers.isEmpty());
        } else {
            Assert.assertFalse(integers.isEmpty());
        }

    }

    @Test
    public void size() {
        integers.size();
    }
}