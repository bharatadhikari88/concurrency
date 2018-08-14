package org.eagle.concurrency;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * first arrange element in priority
 * than call getdelay from high priority to low
 * second elment will not be removed untill first getdelay return 0.
 * compareTo method used to return priority if it return > 0 than parameter has high priorty
 * 
 * @author Bharat
 *
 */
public class DelayBlockingQueueExample implements Runnable{

	@Override
	public void run() {
		DelayQueue<Delayed> delayQueue = new DelayQueue<Delayed>();
		delayQueue.put(new DelayElement("A"));
		delayQueue.put(new DelayElement("B"));
		System.out.println("Element inserted");
		try {
			delayQueue.take();
			delayQueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Element removed");
		
	}
	
	public static void main(String[] args) {
		new Thread(new DelayBlockingQueueExample()).start();
	}
	
	private class DelayElement implements Delayed{
		private String name;
		public  DelayElement(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Delayed obj) {
			/** asking for priorty number > 0 mean obj has high priority and getdelay called first for obj **/
			return -1;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			/** keep calling this method on interval of return value until 0 return **/
			System.out.println("Delayed called for " + name);
			return unit.convert(0, TimeUnit.SECONDS);
		}
		
	}

}


