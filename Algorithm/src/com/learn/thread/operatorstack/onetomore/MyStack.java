package com.learn.thread.operatorstack.onetomore;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List<String> list = new ArrayList<String>();
	public synchronized void push(){
		try {
			//此处用while和if均可
			if (list.size() == 1) {
				this.wait();
			}
			list.add("anyString"+Math.random());
			//此处用notify和notifyAll均可
			this.notify();
			System.out.println("push="+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized String pop(){
		String resultValue = "";
		try {
			//使用while 防止被同类进程唤醒后未经判断继续操作
			while (list.size() == 0) {
				System.out.println("pop操作中的："+Thread.currentThread().getName()+"线程呈wait状态");
				this.wait();
			}
			resultValue = list.get(0);
			list.remove(0);
			//notifyAll 保证可以唤醒生产者线程
			this.notifyAll();
			System.out.println("pop="+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return resultValue;
	}
}
