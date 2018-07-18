package com.learn.tree;

public class AVLTree<E extends Comparable<E>> {
	
	private Node<E> root;
	
	public AVLTree(){
		this.root = null;
	}
	
	public void insert(E e){
		root = this.insert(e,root);
	}
	
	/**
	 * 插入节点，生成平衡二叉树
	 * @param e
	 * @param avlTree
	 * @return
	 */
	public Node<E> insert(E e,Node<E> subRoot){
		if(subRoot == null){
			return new Node<E>(e);
		}
		int compareResult = e.compareTo(subRoot.getData());
		if(compareResult < 0 ){
			//e < avlTree.getData(); 放到左子树
			//递归插入到合适的位置
			Node<E> temp = insert(e,subRoot.getLeft());
			subRoot.setLeft(temp);
			
			if(height(subRoot.getLeft()) - height(subRoot.getRight()) > 1){
				//判断左子树的高度不平衡
				if(e.compareTo(subRoot.getLeft().getData()) < 0){
					//e插入到左子树的左子树上，符合LL，使用右旋调整
					subRoot = rightRotate(subRoot);
				}else{
					//e插入到左子树的右子树上，符合LR，使用先左旋再右旋调整
					subRoot = leftAndRightRotate(subRoot);
				}
			}
		}else{
			//e >= subRoot.getData();放到右子树
			Node<E> temp = insert(e,subRoot.getRight());
			subRoot.setRight(temp);
			if(height(subRoot.getRight()) - height(subRoot.getLeft()) > 1){
				if(e.compareTo(subRoot.getRight().getData()) < 0){
					subRoot = leftRotate(subRoot);
				}else{
					subRoot = rightAndLeftRotate(subRoot);
				}
			}
		}
		int subRootHeight = getMaxHeight(subRoot.getLeft(),subRoot.getRight());
		subRoot.setHeight(subRootHeight);
		return subRoot;
	}
	
	
	public Node<E> remove(E e,Node<E> subRoot){
		if(subRoot == null){
			return null;
		}
		int compareResult = e.compareTo(subRoot.getData());
		if(compareResult < 0){
			Node<E> temp = remove(e,subRoot.getLeft());
			subRoot.setLeft(temp);
		}else{
			
		}
		
		return null;
	}
	
	
	/**
	 * 右旋：左子树的调整
	 *   d			   b
	 *  b	  ===>   a   d 
	 * a  c			    c
	 * @param avlRoot
	 * @return
	 */
	private Node<E> rightRotate(Node<E> subRoot){
		//获取子树根的左子树
		Node<E> newRoot = subRoot.getLeft();
		//根的左子树设为子节点的右子树
		subRoot.setLeft(newRoot.getRight());
		//子节点的右子树
		newRoot.setRight(subRoot);
		//重新计算子树高度
	
		int avlRootHeight = getMaxHeight(subRoot.getLeft(),subRoot.getRight());
		subRoot.setHeight(avlRootHeight);
		
		int newRootHeight = getMaxHeight(newRoot.getLeft(),newRoot.getRight());
		newRoot.setHeight(newRootHeight);
		return newRoot;
	}
	
	/**
	 * 左旋
	 * b			 d
	 *  d	===>   b   e
	 *c  e			c
	 *   
	 * @param subRoot
	 * @return
	 */
	private Node<E> leftRotate(Node<E> subRoot){
		Node<E> newRoot = subRoot.getRight();
		subRoot.setRight(newRoot.getLeft());
		newRoot.setLeft(subRoot);
		int avlRootHeight = getMaxHeight(subRoot.getLeft(),subRoot.getRight());
		subRoot.setHeight(avlRootHeight);
		
		int newRootHeight = getMaxHeight(newRoot.getLeft(), newRoot.getRight());
		newRoot.setHeight(newRootHeight);
		return newRoot;
	}
	
	/**
	 * 先左旋再右旋
	 *	 c			c		  b
	 * a	 ===>  b   ===>	a   c
	 *   b   	  a	
	 * @param subRoot
	 * @return
	 */
	private Node<E> leftAndRightRotate(Node<E> subRoot){
		subRoot = leftRotate(subRoot);
		return rightRotate(subRoot);
	}
	
	/**
	 * 先右旋再左旋
	 * 	a			  a			  b
	 *    c		===>   b  ===>  a   c
	 *  b               c
	 * @param subRoot
	 * @return
	 */
	private Node<E> rightAndLeftRotate(Node<E> subRoot){
		subRoot = rightRotate(subRoot);
		return leftRotate(subRoot);
	}
	
	private int getMaxHeight(Node<E> left,Node<E> right){
		int leftHeight = height(left);
		int rightHeight = height(right);
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	private int height(Node<E> node){
		return node == null ? -1:node.getHeight();
	}
	
	public static void main(String... args){
		AVLTree<Integer> avlTree = new AVLTree<>();
	}
}
