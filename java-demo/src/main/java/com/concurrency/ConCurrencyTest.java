package com.concurrency;

/*
*@author  Devonmusa
*@version
*2017年1月21日 上午1:00:08
*
*/
public class ConCurrencyTest {

	private static final long count = 100000l;

	public static void main(String[]  args) {
		try {
			concurrency();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		serial();
	}

	private static void serial() {
		long start = System.currentTimeMillis();
		int a = 0;
		for (long i = 0; i < count; i++) {
			a += 5;
		}
		int b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("serial :" + time + "ms,b=" + b);
	}

	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			@SuppressWarnings("unused")
			@Override
			public void run() {
				int a = 0;
				for (long i = 0; i < count; i++) {
					a += 5;
				}
			}
		});
		thread.start();
		int b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;

		thread.join();

		System.out.println("concurrency :" + time + "ms,b=" + b);

	}



}
