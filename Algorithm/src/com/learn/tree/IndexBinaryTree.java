package com.learn.tree;

class IndexNode<T>{
	private T data;
	private IndexNode<T> parent;
	private IndexNode<T> left;
	private IndexNode<T> right;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public IndexNode<T> getParent() {
		return parent;
	}
	public void setParent(IndexNode<T> parent) {
		this.parent = parent;
	}
	public IndexNode<T> getLeft() {
		return left;
	}
	public void setLeft(IndexNode<T> left) {
		this.left = left;
	}
	public IndexNode<T> getRight() {
		return right;
	}
	public void setRight(IndexNode<T> right) {
		this.right = right;
	}
}

public class IndexBinaryTree {
	
	public <T> IndexNode<T> createIndexBinaryTree(T data){
		IndexNode<T> node = new IndexNode<T>();
		node.setData(data);
		node.setParent(null);
		node.setLeft(null);
		node.setRight(null);
		return node;
	}
	
	public <T> void connectNode(IndexNode<T> nParent,IndexNode<T> nLeft,IndexNode<T> nRight){
		if(nParent != null){
			nParent.setLeft(nLeft);
			nParent.setRight(nRight);
			if(nLeft != null){
				nLeft.setParent(nParent);
			}
			if(nRight != null){
				nRight.setParent(nParent);
			}
		}
	}
}
