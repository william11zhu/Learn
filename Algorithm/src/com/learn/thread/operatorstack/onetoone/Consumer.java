package com.learn.thread.operatorstack.onetoone;

public class Consumer {
	private MyStack myStack;

	public Consumer(MyStack myStack) {
		super();
		this.myStack = myStack;
	}
	
	public void popService() {
		System.out.println("pop=" + myStack.pop());
		
	}
}
