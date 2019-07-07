package com.learn.basic.tree;

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
/**
 * 剑指offer
 * 面试题8：二叉树的下一个节点
 * @author EX_WLJR_ZHUJIEJIAO
 *
 */
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
	
	/**
	 * 中序遍历下一个节点
	 * @param node
	 * @return
	 */
	public <T> IndexNode<T> getNext(IndexNode<T> node){
		if(node == null) return null;
		IndexNode<T> nextNode = null;
		if(node.getRight() != null){
			nextNode = node.getRight();	
			while(nextNode.getLeft() != null){
				nextNode = nextNode.getLeft();
			}	
		}else if(node.getParent() != null){
			IndexNode<T> current = node;
			IndexNode<T> parent = node.getParent();
			while(parent != null && current == parent.getRight()){
				current = parent;
				parent = parent.getParent();
			}
			nextNode = parent;
		}
		return nextNode;
	}
	
	
	public static void main(String... args){
		IndexBinaryTree bt = new IndexBinaryTree();
		IndexNode<Integer> pNode8 = bt.createIndexBinaryTree(8);
	    IndexNode<Integer> pNode6 = bt.createIndexBinaryTree(6);
	    IndexNode<Integer> pNode10 = bt.createIndexBinaryTree(10);
	    IndexNode<Integer> pNode5 = bt.createIndexBinaryTree(5);
	    IndexNode<Integer> pNode7 = bt.createIndexBinaryTree(7);
	    IndexNode<Integer> pNode9 = bt.createIndexBinaryTree(9);
	    IndexNode<Integer> pNode11 = bt.createIndexBinaryTree(11);

	    bt.connectNode(pNode8, pNode6, pNode10);
	    bt.connectNode(pNode6, pNode5, pNode7);
	    bt.connectNode(pNode10, pNode9, pNode11);

	    IndexNode<Integer> parent = bt.getNext(pNode7);
	    System.out.print(parent.getData());
	}
}
