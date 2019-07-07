package com.learn.thread.operatorstack.onetomore;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List<String> list = new ArrayList<String>();
	public synchronized void push(){
		try {
			//�˴���while��if����
			if (list.size() == 1) {
				this.wait();
			}
			list.add("anyString"+Math.random());
			//�˴���notify��notifyAll����
			this.notify();
			System.out.println("push="+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized String pop(){
		String resultValue = "";
		try {
			//ʹ��while ��ֹ��ͬ����̻��Ѻ�δ���жϼ�������
			while (list.size() == 0) {
				System.out.println("pop�����еģ�"+Thread.currentThread().getName()+"�̳߳�wait״̬");
				this.wait();
			}
			resultValue = list.get(0);
			list.remove(0);
			//notifyAll ��֤���Ի����������߳�
			this.notifyAll();
			System.out.println("pop="+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return resultValue;
	}
}
