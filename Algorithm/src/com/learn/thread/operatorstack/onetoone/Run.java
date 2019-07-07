package com.learn.thread.operatorstack.onetoone;

public class Run {

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		Producer p = new Producer(myStack);
		Consumer c = new Consumer(myStack);
		
		P_Thread pThread = new P_Thread(p);
		C_Thread cThread = new C_Thread(c);
		
		pThread.start();
		cThread.start();
	}

}
