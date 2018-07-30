package com.learn.thread.waitnotify;

public class Add {
	private String lock;
	public Add(String lock){
		super();
		this.lock = lock;
	}
	
	public void add(){
		synchronized(lock){
			
			System.out.println(Thread.currentThread().getName()+" list add");
			ValueObject.list.add("anyThing");
			lock.notifyAll();
		}
	}
}
