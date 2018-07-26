package com.learn.basic.list;

import java.util.Stack;

public class ListQuestions {
	private class Node {
		private int data;
		private Node next;
	}

	private Node head;

	/**
	 * 向表头插入节点
	 * @param node
	 * @return
	 */
	public Node add(Node node) {
		node.next = head;
		head = node;
		return head;
	}

	/**
	 * 删除指定节点
	 * 1、若节点不为尾节点删除时间复杂度为O(1)
	 * 2、若节点为尾节点则时间复杂度为O(n)
	 * @param node
	 * @return
	 */
	public boolean delete(Node node) {
		if (head == null || node == null) {
			return false;
		}
		Node temp = node.next;
		if (temp != null) {
			node.data = temp.data;
			node.next = temp.next;
			return true;
		}
		Node cHead = head;
		Node preNode = head;
		while (cHead != null) {
			if (cHead.data == node.data) {
				preNode.next = cHead.next;
				return true;
			}
			preNode = cHead;
			cHead = cHead.next;
		}
		return false;
	}

	public Node reverseList(boolean useLoop) {
		if (useLoop) {
			return reverseByLoop();
		}
		return reverseByRecursion(head);
	}

	/**
	 * 循环反转链表
	 * @return
	 */
	private Node reverseByLoop() {
		if (head == null) {
			return head;
		}
		Node newHead = null;
		Node current = head;
		while (current != null) {
			Node temp = current.next;
			current.next = newHead;
			newHead = current;
			current = temp;
		}
		return newHead;
	}

	/**
	 * 递归 反转链表
	 * @param node
	 * @return
	 */
	private Node reverseByRecursion(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node temp = reverseByRecursion(node.next);
		node.next.next = node;
		node.next = null;
		return temp;
	}
	
	/**
	 * 寻找倒数第k个节点
	 * @param k
	 * @return
	 */
	public Node getKthNode(int k){
		if(k < 0) return null;
		Node node = head;
		Node kthNode = head;
		while(node != null){
			if(k > 0){
				k--;
			}else{
				kthNode = kthNode.next;
			}
			node = node.next;
		}
		if(k > 0) return null;
		return kthNode;
	}
	
	/**
	 * 判断是否存在环，若存在返回环内节点，否则返回null
	 * @return
	 */
	public Node hasCircle(Node head){
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				return fast;
			}
		}
		return null;
	}
	
	/**
	 * 寻找环的入口
	 * @return
	 */
	public Node findLoopPort(){
		Node fast = head;
		Node slow = head;
		//判断链表中是否存在环
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
		}
		if(fast != slow){
			return null;
		}
		//存在环时，快指针退回到头，步长变成1，当快慢指针相遇时，必然为环的入口。
		fast = head;
		while(fast != slow){
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	
	
	/**
	 * 链表不带环:判断尾节点是否是同一个
	 * 如果相交尾节点必然相同
	 * @param head1
	 * @param head2
	 * @return
	 */
	public boolean isIntersect(Node head1,Node head2){
		if(head1 == null || head2 == null){
			return false;
		}
		while(head1.next != null){
			head1 = head1.next;
		}
		while(head2.next != null){
			head2 = head2.next;
		}
		
		if(head1 == head2){
			return true;
		}
		return false;
	}
	
	/**
	 * 链表带环:相交的环为同一个环
	 * 从链一快慢指针的相交点总是可以到达链二快慢指针的相交点
	 * @param head1
	 * @param head2
	 * @return
	 */
	public boolean isIntersectWithCircle(Node head1,Node head2){
		Node circle1 = hasCircle(head1);
		if(circle1 == null) return false;
		Node circle2 = hasCircle(head2);
		if(circle2 == null) return false;
		Node temp = circle1.next;
		while(temp != circle1){
			if(temp == circle2){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public int length(){
		int len = 0;
		Node h = head;
		while(h != null){
			len++;
			h = h.next;
		}
		return len;
	}
	
	public int length(Node head){
		int len = 0;
		while(head != null){
			len++;
			head = head.next;
		}
		return len;
	}
	
	public Node getIntersectNode(Node head1,Node head2){
		int len1 = length(head1);
		int len2 = length(head2);
		if(len1 > len2){
			for(int i=0;i<len1-len2;i++){
				head1 = head1.next;
			}
		}else{
			for(int i=0;i<len2-len1;i++){
				head2 = head2.next;
			}
		}
		
		while(head1 != null){
			if(head1 == head2){
				return head1;
			}
			head1=head1.next;
			head2=head2.next;
		}
		return null;
	}
	
	/**
	 * 逆序打印链表：循环
	 * @param head
	 */
	public void printListReversingly_Iteratively(Node head){
		Stack<Integer> stack = new Stack<Integer>();
		while(head != null){
			stack.push(head.data);
			head = head.next;
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+",");
		}
	}
	
	/**
	 * 逆序打印链表：递归
	 * @param head
	 */
	public void printListReversingly_Recursively(Node head){
		if(head == null) return;
		printListReversingly_Recursively(head.next);
		System.out.print(head.data+",");
	}
	
	public static void main(String... args){
		ListQuestions lq = new ListQuestions();
		for(int i=1;i <10;i++){
			Node node =  lq.new Node();
			node.data = i;
			lq.add(node);
		}
		System.out.print(lq.getKthNode(1).data);
		
	}
}
