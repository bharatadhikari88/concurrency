package org.eagle.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/** Cyclic barrier provides meeting point. thread wait at barrier point using barrier.await() 
 * when all threads reach to barrier point. Barrier action gets called and then they start moving.
 * @author Bharat
 *
 */
public class CyclicBarrierSample implements Runnable {
	CyclicBarrier barrier;
	public CyclicBarrierSample(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		if("A".equalsIgnoreCase(Thread.currentThread().getName())){
			System.out.println("A barrier started");
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			} 
			System.out.println("A barrier stopped");
		}else if("B".equalsIgnoreCase(Thread.currentThread().getName())){
			try {
				Thread.sleep(5000);
				System.out.println("B barrier started");
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			} 
			System.out.println("B barrier stopped");
		}
	}
	
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(2,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("barrier completed");
				
			}
		});
		CyclicBarrierSample sample = new CyclicBarrierSample(barrier);
		
		Thread t1 = new Thread(sample,"A");
		Thread t2 = new Thread(sample,"B");
		t1.start();
		t2.start();
	}

}
