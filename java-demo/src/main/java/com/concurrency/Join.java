package com.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/10/15.
 */
public class Join {

    public static void main(String[] args) throws Exception {

        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            // 每 个 线 程 拥 有 前 一 个 线 程 的 引 用， 需 要 等 待 前 一 个 线 程 终 止， 才 能 从 等 待 中 返 回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        } TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}



