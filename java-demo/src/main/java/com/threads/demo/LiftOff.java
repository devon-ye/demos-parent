package com.threads.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private  int id = 0;

	public LiftOff() {
	}

    public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + "). ";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}

	public static void main(String[] args) {
		 Thread t = new Thread(new LiftOff());
		  t.setDaemon(true);
		 t.start();
		 // ExecutorService exec = Executors.LiftOff();
		for (int i = 0; i < 10; i++) {
			// new Thread(new LiftOff()).start();
			// exec.execute(new LiftOff());
			// exec.shutdown();
		}
		System.out.println("Waiting for LiftOff");

	}
}
