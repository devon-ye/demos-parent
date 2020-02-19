package org.devon.concurrency.synchronizeds;

import java.util.concurrent.TimeUnit;

/**
 * @author devon.ye
 * @datetime 2020/2/19 10:04 下午
 * @since
 */
public class MultiThreadWaitNotifySynchronized implements Runnable {

	private Object lock = new Object();

	private int status = 0;
	private char CH = 'A';
	private volatile boolean RUNNING = false;
	private StringBuffer result = new StringBuffer();


	private void printUpperLetter() {
		synchronized (lock) {
			while (status % 2 != 1) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(CH);
			result.append(CH);
			status++;
			if (CH < 'Z') {
				CH += 1;
			} else {
				RUNNING = false;
			}
			lock.notify();

		}
	}

	private void printLowerLetter() {
		synchronized (lock) {
			while (status % 2 != 0) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			char ch = (char) (CH + 32);
			System.out.println(ch);
			result.append(ch);
			status++;
			if (ch < 'z') {
				ch += 1;
			}else {
				RUNNING = false;
			}
			lock.notify();
		}
	}

	@Override
	public void run() {
		RUNNING = true;
		while (RUNNING) {
			printLowerLetter();
			printUpperLetter();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.result.toString());
	}

	public static void main(String[] args) {
		MultiThreadWaitNotifySynchronized waitNotifySynchronized = new MultiThreadWaitNotifySynchronized();
		Thread thread1 = new Thread(waitNotifySynchronized);
		Thread thread2 = new Thread(waitNotifySynchronized);
		thread1.start();
		thread2.start();
	}
}
