package com.spacetime.test;

public class Base {
	public void check(Object a){
		System.out.println("Base Object");
	}
	static private class Child extends Base{
		public void check(Object a){
			System.out.println("child Object");
		}
		public void check(Integer a){
			System.out.println("child in");
		}
	}
	
	public static void main(String[] args) {
		Child b = new Child();
		((Base)b).check(2);
	}
	
}


