/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.algorithms.recursive;

import org.devon.algorithms.recursion.HanoiTower;
import org.junit.Test;

import java.util.Stack;

/**
 * @author dewen.ye
 * @date 2019/2/17 11:18
 */
public class HanoiTowerTest {

    @Test
    public void hanoi() {
        Stack<Integer> towerA = new Stack <>();
        Stack <Integer> towerB = new Stack <>();
        Stack <Integer> towerC = new Stack <>();
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.addTowerA(towerA);
        hanoiTower.print(towerA,towerB,towerC);

        hanoiTower.hanoi(8, towerA, towerB, towerC);
    }
}