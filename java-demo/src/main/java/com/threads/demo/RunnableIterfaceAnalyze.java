package com.threads.demo;

public class RunnableIterfaceAnalyze {

	public static void main(String[] args) {
		MyRunnable myRunnable=new MyRunnable();
		Thread T=new Thread(myRunnable);
		Thread t1=new Thread(myRunnable);
		Thread t2=new Thread(myRunnable);
		Thread t3=new Thread(myRunnable);
		T.start();
		t1.start();
		t2.start();
		t3.start();

	}

}
class MyRunnable implements Runnable{
	private int ticket=20; 
	public void run() {
		
			while(ticket>0){
			//testRunnale();
			System.out.println("鍗栧嚭绗�"+ticket+"寮犵エ");
			ticket--;
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {

			}
	}
		
	}
	public static void testRunnale(){
		MyRunnable myRunnable=new MyRunnable();
		myRunnable.run();
	}
}