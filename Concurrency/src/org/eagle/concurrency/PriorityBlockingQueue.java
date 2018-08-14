package org.eagle.concurrency;

public class PriorityBlockingQueue implements Runnable {

	@Override
	public void run() {
		java.util.concurrent.PriorityBlockingQueue<PriorityElement> priorityBlockingQueue = new java.util.concurrent.PriorityBlockingQueue<PriorityBlockingQueue.PriorityElement>();
		priorityBlockingQueue.put(new PriorityElement("A"));
		priorityBlockingQueue.put(new PriorityElement("B"));
		try {
			System.out.println(priorityBlockingQueue.take().getName());
			System.out.println(priorityBlockingQueue.take().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new Thread(new PriorityBlockingQueue()).start();
	}
	
	private class PriorityElement implements Comparable{
		
		private String name;

		public String getName() {
			return name;
		}

		public PriorityElement(String name){
			this.name = name;
		}

		@Override
		public int compareTo(Object o) {
			return 1;
		}
		
	}

}
