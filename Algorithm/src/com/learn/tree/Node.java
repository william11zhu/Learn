package com.learn.tree;

public class Node<T> {
	private T data;
	private Node<T> left;
	private Node<T> right;
	
	private int height;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Node(){
	}
	
	public Node(T t){
		this.data = t;
		this.height = 0;
		this.left = null;
		this.right = null;
	}
}
