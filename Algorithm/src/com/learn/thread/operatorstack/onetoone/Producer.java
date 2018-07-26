package com.learn.thread.operatorstack.onetoone;

public class Producer {
	private MyStack myStack;

	public Producer(MyStack myStack) {
		super();
		this.myStack = myStack;
	}
	
	public void pushService() {
		myStack.push();
	}
}
