package com.spacetime.test;

public interface Interface3 extends Interface2 {
	default void abc(){
		System.out.println("Interface2");
	}
}
