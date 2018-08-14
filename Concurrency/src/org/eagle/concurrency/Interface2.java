package com.spacetime.test;

public interface Interface2 {
	int a = 5;
	default void abc(){
		System.out.println("Interface2");
	}
}
