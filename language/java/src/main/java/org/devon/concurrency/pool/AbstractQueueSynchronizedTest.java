package org.devon.concurrency.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author devon.ye
 * @datetime 2020/3/23 8:24 下午
 * @since
 */
public class AbstractQueueSynchronizedTest {
    private static ExecutorService executorService = new ThreadPoolExecutor(1,5,0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(10));
    private static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
        while (true) {
			executorService.submit(new Runnable() {
				@Override
				public void run() {
                   while (true){
					   lock.lock();
					   System.out.println("Running....ThreadName:"+Thread.currentThread().getName());
					   try {
						   Thread.sleep(2000);
					   } catch (InterruptedException e) {
						   e.printStackTrace();
					   }finally {
						   lock.unlock();
					   }
				   }
				}
			});
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
