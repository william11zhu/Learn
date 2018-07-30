package com.learn.thread.operatorstack.onetoone;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List<String> list = new ArrayList<String>();
	public synchronized void push(){
		try {
			if (list.size() == 1) {
				this.wait();
			}
			list.add("anyString"+Math.random());
			this.notify();
			System.out.println("push="+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized String pop(){
		String resultValue = "";
		try {
			if (list.size() == 0) {
				System.out.println("pop操作中的："+Thread.currentThread().getName()+"线程呈wait状态");
				this.wait();
			}
			resultValue = list.get(0);
			list.remove(0);
			this.notify();
			System.out.println("pop="+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return resultValue;
	}
}
