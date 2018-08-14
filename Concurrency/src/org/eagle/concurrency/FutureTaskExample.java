package org.eagle.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/** Future task help us in using callable task where ruunable allowed **/
public class FutureTaskExample{

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return Thread.currentThread().getName();
			}
		});
		//future task executes only once
		
		
//		futureTask.run();
//		System.out.println(futureTask.get());
		
		Future task = Executors.newCachedThreadPool().submit(futureTask);
		System.out.println(futureTask.get());
		
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}

}
