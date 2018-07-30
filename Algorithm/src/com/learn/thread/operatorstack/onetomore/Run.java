package com.learn.thread.operatorstack.onetomore;

public class Run {

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		Producer p = new Producer(myStack);
		Consumer c1 = new Consumer(myStack);
		Consumer c2 = new Consumer(myStack);
		Consumer c3 = new Consumer(myStack);
		Consumer c4 = new Consumer(myStack);
		Consumer c5 = new Consumer(myStack);
		
		P_Thread pThread = new P_Thread(p);
		pThread.start();
		
		C_Thread cThread1 = new C_Thread(c1);
		C_Thread cThread2 = new C_Thread(c2);
		C_Thread cThread3 = new C_Thread(c3);
		C_Thread cThread4 = new C_Thread(c4);
		C_Thread cThread5 = new C_Thread(c5);
		
		cThread1.start();
		cThread2.start();
		cThread3.start();
		cThread4.start();
		cThread5.start();
	}

}
