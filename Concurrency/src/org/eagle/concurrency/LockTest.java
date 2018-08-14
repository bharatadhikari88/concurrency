package org.eagle.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/** Lock are same as synchronized block but we can have multiple independent locks.
 * lock.newCondition() for inter thread communication same as notify and wait.
 *  
 * @author Bharat
 *
 */
public class LockTest implements Runnable {
	Lock operationALock = new ReentrantLock();
	Lock operationBLock = new ReentrantLock();
	Condition operationALockCondition = operationALock.newCondition();

	@Override
	public void run() {
		if (Thread.currentThread().getName().contains("A")) {
			operationA();
		} else {
			operationB();
		}
	}

	private void operationB() {
		operationALock.lock();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + i);
			operationALockCondition.signal();
			try {
				operationALockCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		operationALock.unlock();
	}

	private void operationA() {
		operationALock.lock();
		 subOperationA();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + i);
			operationALockCondition.signal();
			try {
				operationALockCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		operationALock.unlock();
	}

	private void subOperationA() {
		/**
		 * lock provide reentrant :- same lock is used b/w inner calls,
		 * Semaphore not provide
		 **/
		operationALock.lock();
		System.out.println("Sub operation");
		operationALock.unlock();
	}

	public static void main(String[] args) {
		LockTest lockTest = new LockTest();
		for (int i = 0; i < 2; i++) {
			Thread a = new Thread(lockTest, (i % 2 == 0 ? "A" : "B") + i);
			a.start();
		}
	}

}
