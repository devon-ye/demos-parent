package org.devon.concurrency.fork.join;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author devon.ye
 * @datetime 2020/3/21 3:15 下午
 * @since
 */
public class ForkJoinPoolFactory implements Runnable {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private CountDownLatch latch = new CountDownLatch(1);

	public static void main(String[] args) {
		ForkJoinPoolFactory factory = new ForkJoinPoolFactory();
		Thread thread = new Thread(factory,"TEST1");
		thread.start();
		Thread thread2 = new Thread(factory,"TEST2");
		thread2.start();

		Thread.yield();
	}

	@Override
	public void run() {
        int i= 0;
		while (true) {
			try {
				latch.countDown();
				lock.lock();
					//TimeUnit.SECONDS.sleep(1);
				condition.await(1,TimeUnit.SECONDS);
					System.out.println("running...");

					if (i > 20) {
						Thread.yield();
					}
					i++;
				condition.signalAll();
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();

			}
		}
	}


}
