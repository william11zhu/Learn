package com.learn.offer.queue;

import java.util.Stack;

public class  StackToQueue<T> {
	private Stack<T> stack1;
	private Stack<T> stack2;
	
	public StackToQueue(){
		stack1 = new Stack<T>();
		stack2 = new Stack<T>();
	}
	
	
	public void appendTail(T node){
		stack1.push(node);
	}
	
	public void deleteHead(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				T t = stack1.pop();
				stack2.push(t);
			}
		}
		if(stack2.isEmpty()){
			throw new NullPointerException("The queue is null");
		}
		stack2.pop();
	}
	
	public static void main(String... args){
		StackToQueue<Integer> stq = new StackToQueue<Integer>();
		
		for(int i=0;i<5;i++)
			stq.appendTail(i);
		System.out.println();
		stq.deleteHead();
		stq.deleteHead();
		System.out.println();
		for(int i = 5;i < 10;i++)
			stq.appendTail(i);
		System.out.println();
		for(int i =0;i<8;i++)
			stq.deleteHead();
	}
}
