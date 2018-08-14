package com.spacetime.test;

import java.util.Random;

public class StarvationTest implements Runnable {

	@Override
	public void run() {
		syncMethod();
		
	}

	private synchronized void syncMethod() {
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		StarvationTest starvationTest = new StarvationTest();
		Thread thread;
		Random random = new Random();
		int priorty;
		while(true){
			thread = new Thread(starvationTest);
			priorty = random.nextInt(Thread.MAX_PRIORITY-Thread.MIN_PRIORITY) + Thread.MIN_PRIORITY;
			thread.setPriority(priorty);
			thread.start();
		}
	}

}
