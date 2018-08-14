package org.eagle.concurrency;

import java.util.concurrent.ArrayBlockingQueue;

public class FailFast {

	public static void main(String[] args) {
		/*ArrayList list = new ArrayList<>(Arrays.asList(new String[]{"A","B","C"}));
		list.forEach(item ->{
			System.out.println(item);
			list.add("D");
		});*/
		
		ArrayBlockingQueue queue = new ArrayBlockingQueue<>(7);
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.forEach(item -> {
			System.out.println(item);
			if("C".equals(item)){
				queue.add("D");
			}
		});
	}

}
