package org.devon.code.review;

import java.util.concurrent.TimeUnit;

/**
 * @author devon.ye
 * @datetime 2020/2/22 1:52 下午
 * @since
 */
public class ShareResource implements Runnable {
	private Object lock = new Object();
	private int method = -1;

	private void printA() throws InterruptedException {
		synchronized (lock) {
			if (method % 3 == 0) {
				lock.wait();
			}

			System.out.println("A");
			method++;
			lock.notifyAll();
		}
	}

	private void printB() throws InterruptedException {
		synchronized (lock) {
			if (method % 3 == 1) {
				lock.wait();
			}
			System.out.println("B");
			method++;
			lock.notifyAll();
		}
	}

	private void printC() throws InterruptedException {
		synchronized (lock) {
			if (method % 3 == 2) {
				lock.wait();
			}

			System.out.println("C");
			method++;
			lock.notifyAll();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				printA();
				printB();
				printC();
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		ShareResource resource = new ShareResource();
		Thread t1 = new Thread(resource);
		Thread t2 = new Thread(resource);
		Thread t3 = new Thread(resource);
		t1.start();
		t2.start();
		t3.start();
	}
}
