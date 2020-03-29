package org.devon.concurrency.pool;

import java.util.concurrent.CountDownLatch;

/**
 * @author devon.ye
 * @datetime 2020/2/20 12:05 下午
 * @since
 */
public class StaticClassTest {
	private static StaticClassTest INSTANCE = new StaticClassTest();

	static {
		System.out.println("inti static block");
	}

	public static StaticClassTest getInstance() {
		return INSTANCE;
	}

	StaticClassTest() {
		final CountDownLatch latch = new CountDownLatch(1);
		new Thread(new Runnable() {
			@Override
			public void run() {
				doRun(latch);
			}
		}).start();
		try {
			System.out.println("waiting on config, thread:" + Thread.currentThread().getName());
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main thread init finished");
	}

	// 这里如果是private或者static，方法执行前会卡住
	public void doRun(CountDownLatch latch) {
		System.out.println("running another thread:" + Thread.currentThread().getName());
		doPrivate();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("do run finished. thread:" + Thread.currentThread().getName());
	}

	// 这里即使是private也不卡住，加static卡住
	private void doPrivate() {
		System.out.println("do private");
	}

	public static void main(String[] args) {
		StaticClassTest.getInstance();
	}
}

