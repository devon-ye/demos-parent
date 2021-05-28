package org.devon.concurrency.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenovo on 2017/10/15.
 */
public class MultiConditionSynchronizedUseCase implements Runnable {
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();
	private int i = 0;

	public void conditionWait1() throws InterruptedException {
		lock.lock();
		try {
			while (i % 3 != 0)
				condition1.await();

			System.out.println("a");

			i++;
			condition2.signal();
		} finally {
			lock.unlock();
		}
	}

	public void conditionWait2() throws InterruptedException {
		lock.lock();
		try {
			while (i % 3 != 1)
				condition2.await();

			System.out.println("b");
			i++;
			condition3.signal();
		} finally {
			lock.unlock();
		}
	}

	public void conditionWait3() {
		lock.lock();
		try {
			while (i % 3 != 2)
				condition3.await();
			System.out.println("c");
			i++;

			condition1.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				conditionWait1();
				conditionWait2();
				conditionWait3();
				 TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MultiConditionSynchronizedUseCase condition = new MultiConditionSynchronizedUseCase();
		Thread T1 = new Thread(condition,"A_WAIT_THREAD");
		Thread T2 = new Thread(condition,"B_WAIT_THREAD");
		Thread T3 = new Thread(condition,"C_WAIT_THREAD");
		T1.start();
		T2.start();
		T3.start();


	}
}
