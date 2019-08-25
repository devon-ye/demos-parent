/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithm.recursive;

import org.devon.algorithms.recursive.Ackerman;
import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/17 11:11
 */
public class AckermanTest {

    @Test
    public void acker() {
        Ackerman ackerman = new Ackerman();
        ackerman.acker(3,5);
    }
}