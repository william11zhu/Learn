package com.learn.thread.waitnotify;

public class Run {

	public static void main(String[] args) throws InterruptedException{
		String lock = new String("");
		Add add = new Add(lock);
		Subtract subtract = new Subtract(lock);
		ThreadSubtract threadSubtract_1 = new ThreadSubtract(subtract);
		threadSubtract_1.setName("subtractThread_1");
		//threadSubtract_1.setPriority(10);
		threadSubtract_1.start();
		
		ThreadSubtract threadSubtract_2 = new ThreadSubtract(subtract);
		threadSubtract_2.setName("subtractThread_2");
		//threadSubtract_2.setPriority(0);
		threadSubtract_2.start();
		
		Thread.sleep(1000);
		
		ThreadAdd addThread = new ThreadAdd(add);
		addThread.setName("addThread");
		//设置为守护线程（后台线程）
		//addThread.setDaemon(true);
		addThread.start();

	}

}
