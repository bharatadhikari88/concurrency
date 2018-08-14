package org.eagle.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * Converting Runnable class to Callable
 *
 */
public class RunnableAdapterSample implements Runnable{
	
	private StringBuilder result;
	
	public RunnableAdapterSample(StringBuilder result) {
		this.result = result;
	}
	
	@Override
	public void run() {
		System.out.println(result);
		result.append("done");
	}
	
	public static void main(String[] args) {
		StringBuilder result = new StringBuilder("start");
		Callable<StringBuilder> callable = Executors.callable(new RunnableAdapterSample(result), result);
		Future<StringBuilder> future = Executors.newSingleThreadExecutor().submit(callable);
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
