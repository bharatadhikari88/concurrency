package org.eagle.concurrency;

import java.util.concurrent.CountDownLatch;
/** latch count await() stop the thread until count down to 0
 *  useful when we start the process after end of specific set of processes
 *  **/
public class CountDownLatchExample implements Runnable{
	
	private CountDownLatch latch;
	
	public CountDownLatchExample(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
			System.out.println("left out latch " + latch.getCount());
		}
	}
	

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		CountDownLatchExample example = new CountDownLatchExample(latch);
		new Thread(example).start();
		new Thread(example).start();
		new Thread(example).start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Latching completed");
	}

	

}
