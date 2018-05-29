package com.learning;

public interface Base {
	
	default void defaultMethod(String name){
		System.out.println("Interface's default method "+ name);
	}
	
	public void saySomething(String words);
}
