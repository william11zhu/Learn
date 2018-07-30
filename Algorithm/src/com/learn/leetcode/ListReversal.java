package com.learn.leetcode;

public class ListReversal {
	
	public Node reversal(Node node){
		
		//设置反转链表的头指针
		Node revNode= null;
		
		while(node != null){
			//将原链表的下一个位置保存到临时变量中
			Node temp = node.getNext();
			//将当前位置指向反转链表的头
			node.setNext(revNode);
			//将头指针修改为当前节点
			revNode = node;
			//将备份赋给原表头
			node = temp;
		}
		
		return revNode;
	}
	
	/**
	 * 1、递归直达最后一个节点，此时node为最后一个节点，走到if分支返回最后一个节点
	 * 2、revNode接受最后一个节点的值，此时node为倒数第二节点，
	 * 3、此时需找到node的后一个节点，将node后一个节点指向node
	 * 4、断开node的指针，防止循环
	 * @param node
	 * @return
	 */
	
	public Node in_Reversal(Node node){
		//第一个条件是防止node为空的情况
		if(node == null || node.getNext() == null) return node;
		Node revNode = in_Reversal(node.getNext());
		node.getNext().setNext(node); 
		node.setNext(null);
		return revNode;
	}
	
	public static void main(String... args){
		Node node = null;

		for(int i= 0;i<10;i++){
			Node temp = new Node();
			temp.setData(i+"");
			temp.setNext(node);
			node = temp;
		}
		
		Node temp = node;
		while( temp != null){
			System.out.print(temp.getData()+",");
			temp = temp.getNext();
		}
		
		System.out.println();
		node = new ListReversal().in_Reversal(node);
		
		while(node!= null){
			System.out.print(node.getData()+",");
			node = node.getNext();
		}
	}
}
