package org.devon.algorithm.recursive;

import java.util.Stack;

/**
 * Created by lenovo on 2017/12/3.
 */
public class HanoiTower {
//    private Stack<Integer> towerA;
//    private Stack<Integer> middle;
//    private Stack<Integer> target;

    public HanoiTower() {

    }

    public void hanoi(int n, Stack <Integer> source, Stack <Integer> middle, Stack <Integer> target) {
        if (n == 0) {
            return;
        }
        print(source,middle, target);

        // 移动上面所有盘子到中间
        hanoi(n - 1, source, target, middle);
        print(source,middle, target);

        // 最下面盘子移动到目标位置
        target.push(source.pop());
        print(source,middle, target);

        // 把上面所有盘子从中间移动至目标位置
        hanoi(n - 1, middle, source, target);

        print(source,middle, target);

    }

    public void print(Stack <Integer> source,Stack <Integer> middle,Stack <Integer> target) {
        System.out.println("source:" + source + ", middle:" + middle + ",target:" + target);
    }

    public void addTowerA(Stack <Integer> source) {

        for (int n = 8; n > 0; n--) {
            source.push(n);
        }
    }
}
