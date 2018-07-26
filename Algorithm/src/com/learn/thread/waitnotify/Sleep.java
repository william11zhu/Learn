package com.learn.thread.waitnotify;

public class Sleep {
	
	public void run() {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
