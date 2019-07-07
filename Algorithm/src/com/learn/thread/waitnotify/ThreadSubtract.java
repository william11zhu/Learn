package com.learn.thread.waitnotify;

public class ThreadSubtract extends Thread {
	
	private Subtract s;
	
	public ThreadSubtract(Subtract s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		s.subtract();
	}
	
}
