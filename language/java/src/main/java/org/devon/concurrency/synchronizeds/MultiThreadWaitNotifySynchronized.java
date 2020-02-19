package org.devon.concurrency.synchronizeds;

/**
 * @author devon.ye
 * @datetime 2020/2/19 10:04 下午
 * @since
 */
public class MultiThreadWaitNotifySynchronized implements Runnable {

	private Object lock = new Object();

	private int status = 0;
	private String result;


	private void printUpperLetter() {
		synchronized (lock) {
			while (status % 2 != 1) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("a");
			status++;
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

			System.out.println("A");

			status++;
			lock.notify();
		}
	}

	@Override
	public void run() {
		printLowerLetter();
		printUpperLetter();
	}

	public static void main(String[] args) {
		MultiThreadWaitNotifySynchronized waitNotifySynchronized = new MultiThreadWaitNotifySynchronized();
		Thread thread1 = new Thread(waitNotifySynchronized);
		Thread thread2 = new Thread(waitNotifySynchronized);
		thread1.start();
		thread2.start();
	}
}
