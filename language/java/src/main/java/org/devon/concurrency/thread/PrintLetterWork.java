package org.devon.concurrency.thread;

import java.util.Map;

/**
 * @author devon.ye
 * @datetime 2020/2/19 3:04 下午
 * @since
 */
public class PrintLetterWork {


	static class PrintLetterTask implements Runnable {
		private ThreadLocal<Long> timer = new ThreadLocal<>();
		private boolean flag = false;


		@Override
		public void run() {

		}
	}

	private void printUpperLetter(){
		printLowerLetter();
		this.notify();
	}

	private void printLowerLetter(){
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printUpperLetter();
	}


	public static void main(String[] args) throws InterruptedException {

		PrintLetterTask lowerLetterTask = new PrintLetterTask();

		PrintLetterTask upperLetterTask = new PrintLetterTask();

		Thread thread1 = new Thread(lowerLetterTask);
		Thread thread2 = new Thread(upperLetterTask);

		thread1.start();
		thread2.start();

	}
}
