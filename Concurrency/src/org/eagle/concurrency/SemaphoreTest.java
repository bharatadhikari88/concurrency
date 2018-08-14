package org.eagle.concurrency;

import java.util.concurrent.Semaphore;
/** Semaphore are like lock but it allow n threads to entire before lock gets activated.
 * it is not reentrant
 * @author Bharat
 *
 */
public class SemaphoreTest implements Runnable {
	Semaphore mutex = new Semaphore(1);

	@Override
	public void run() {
		if (Thread.currentThread().getName().contains("A")) {
			runMutexA();
		} else {
			runMutexB();
		}
	}

	private void runMutexA() {
		mutex.acquireUninterruptibly();
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mutex.release();
	}

	private void runMutexB() {
		mutex.acquireUninterruptibly();
		suMutexB();
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mutex.release();
	}
	
	private void suMutexB() {
		/** lock provide reentrant :- same lock is used b/w inner calls, Semaphore not provide **/
		mutex.acquireUninterruptibly();
		System.out.println("Sub mutex");
		mutex.release();
	}

	public static void main(String[] args) {
		SemaphoreTest semaphoreTest = new SemaphoreTest();
		for (int i = 0; i < 10; i++) {
			Thread a = new Thread(semaphoreTest, (i % 2 == 0 ? "A" : "B") + i);
			a.start();
		}
	}

}
