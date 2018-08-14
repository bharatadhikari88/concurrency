package org.eagle.concurrency;

public class ThreadExceptionExample implements Runnable {

	@Override
	public void run() {
		int a = 6/0;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadExceptionExample());
		t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(e);
				
			}
		});
		t1.start();
	}

}
