package org.eagle.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest implements Runnable {
	ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	@Override
	public void run() {
		if(Thread.currentThread().getName().contains("Read")){
			read();
		}else{
			write();
		}
	}
	private void write() {
		readWriteLock.writeLock().lock();
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readWriteLock.writeLock().unlock();
	}
	private void read() {
		readWriteLock.readLock().lock();
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readWriteLock.readLock().unlock();
	}
	public static void main(String[] args) {
		ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
		for (int i = 0; i < 20; i++) {
			Thread a = new Thread(readWriteLockTest, (i % 5 == 0 ? "Write" : "Read") + i);
			a.start();
		}
	}

}
