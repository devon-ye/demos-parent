/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.data.structures.linked;

/**
 * @author dewen.ye
 * @date 2019/2/16 17:51
 */
public interface LinkedListTest<E> {

    default void addElement(int count,Linked<Integer> linked) {
        for (int j = 0; j <count; j++) {
             linked.addFirst(j);
        }
    }
}
