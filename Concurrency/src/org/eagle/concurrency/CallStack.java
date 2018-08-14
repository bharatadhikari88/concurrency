package com.spacetime.test;

public class CallStack {

	public static void main(String[] args) {
		System.out.println(test());
		System.out.println(test2().getI());
		
	}

	private static int test() {
		int i =6;
		try{
			throw new Exception();
		}catch(Exception ex){
			return i;
		}finally{
			i =10;
		}
	}
	
	private static Test test2() {
		Test test = new Test();
		try{
			throw new Exception();
		}catch(Exception ex){
			return test;
		}finally{
			test.setI(10);
		}
	}
	
	private static class Test{
		int i = 6;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
		
	}

}
