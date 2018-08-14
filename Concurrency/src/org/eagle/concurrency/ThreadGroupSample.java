package org.eagle.concurrency;

public class ThreadGroupSample implements Runnable{
	@Override
	public void run() {
		while(!Thread.interrupted()){
			System.out.println(Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		ThreadGroupSample tgs = new ThreadGroupSample();
		ThreadGroup tg = new ThreadGroup("tg");
		Thread t1 = new Thread(tg,tgs,"t1");
		Thread t2 = new Thread(tg,tgs,"t2");
		Thread t3 = new Thread(tg,tgs,"t3");
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			System.out.println(tg.activeCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tg.interrupt();
		System.out.println(tg.activeCount());
	}

}
