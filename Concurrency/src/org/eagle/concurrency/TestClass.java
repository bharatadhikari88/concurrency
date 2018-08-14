package com.spacetime.test;

public class TestClass implements Interface1, Interface2 {
	public void abc(){
		Interface1.super.abc();
		System.out.println(Interface2.a);
	}
}
