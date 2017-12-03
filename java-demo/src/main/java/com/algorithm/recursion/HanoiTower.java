package com.algorithm.recursion;

import java.util.Stack;

/**
 * Created by lenovo on 2017/12/3.
 */
public class HanoiTower {
//    private Stack<Integer> towerA;
//    private Stack<Integer> towerB;
//    private Stack<Integer> towerC;

    public HanoiTower() {

    }

    public void hanoi(int n, Stack <Integer> towerA, Stack <Integer> towerB, Stack <Integer> towerC) {
        if (n == 0) {
            return;
        }
        print(towerA,towerB, towerC);
        hanoi(n - 1, towerA, towerC, towerB);
        print(towerA,towerB, towerC);

        towerC.push(towerA.pop());
        print(towerA,towerB, towerC);

        hanoi(n - 1, towerB, towerA, towerC);
        print(towerA,towerB, towerC);

    }

    public void print(Stack <Integer> towerA,Stack <Integer> towerB,Stack <Integer> towerC) {
        System.out.println("towerA:" + towerA + ", towerB:" + towerB + ",towerC:" + towerC);
    }

    public void addTowerA(Stack <Integer> towerA) {

        for (int n = 8; n > 0; n--) {
            towerA.push(n);
        }
    }

    public static void main(String[] args) {
        Stack <Integer> towerA = new Stack <>();
        Stack <Integer> towerB = new Stack <>();
        Stack <Integer> towerC = new Stack <>();
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.addTowerA(towerA);
        hanoiTower.print(towerA,towerB,towerC);

        hanoiTower.hanoi(8, towerA, towerB, towerC);

    }
}
