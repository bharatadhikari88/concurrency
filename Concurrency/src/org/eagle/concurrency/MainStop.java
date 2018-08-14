package org.eagle.concurrency;

public class MainStop {

	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName());
		try{
			Thread.currentThread().stop();
		}finally{
			System.out.println(Thread.currentThread().getName());
			System.out.println("main finally");
		}
	}

}
