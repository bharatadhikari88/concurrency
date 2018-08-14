package org.eagle.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/**
 * work on work stealing algorithm and all divide and conquer algo can be written on this.
 * @author Bharat
 *
 */
public class ForkJoinSample {
	static class Factorial extends RecursiveTask<Integer>{
		private int fact; 
		public Factorial(int fact) {
			this.fact = fact;
		}
		@Override
		protected Integer compute() {
			if(fact == 1){
				return fact;
			}
			Factorial factorial = new Factorial(fact -1);
			factorial.fork();
			return fact * factorial.join();
		}
		
	}
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		System.out.println(forkJoinPool.invoke(new Factorial(50)));
		
	}

}
