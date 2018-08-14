package com.spacetime.test;

import java.util.logging.Logger;

public class ExceptionTest {
	
	private void abc() throws Abc{
		abc();
	}
	
	public static void main(String[] args) {
		/*try{*/
		Logger.getLogger("abc");
			new ExceptionTest().abc();
		/*}catch(IOException  a){
			System.out.println(a);
		}finally{
			System.out.println("finally");
		}*/
	}
	
	private class Check extends Exception{
		
	}
	private class UnCheck extends RuntimeException{
		
	}
	private class Abc extends Error{
		
	}

}
