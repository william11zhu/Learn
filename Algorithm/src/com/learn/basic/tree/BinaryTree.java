package com.learn.basic.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	public <T> Node<T> rebuildTree(T[] preorder,T[] inorder) throws Exception{
		if(preorder == null 
				|| preorder.length == 0 
				|| inorder == null 
				|| inorder.length == 0){
			return null;
		}
		return rebuildCore(0,preorder.length-1,preorder,0,inorder.length-1,inorder);
	}
	
	/**
	 * 1、在前序序列中寻找根节点root
	 * 2、在中序序列中找到root的位置，则root左边节点为左子节点，root右边节点为右子节点
	 * 3、重复上述步骤，直到所有节点都找完
	 * @param startPre
	 * @param endPre
	 * @param preorder
	 * @param startIn
	 * @param endIn
	 * @param inorder
	 * @return
	 * @throws Exception
	 */
	private <T> Node<T> rebuildCore(int startPre,int endPre,T[] preorder,int startIn,int endIn,T[] inorder) throws Exception{
		T rootValue = preorder[startPre];
		Node<T> root = new Node<T>();
		root.setData(rootValue);
		root.setLeft(null);
		root.setRight(null);
		if(startPre == endPre){
			if(startIn == endIn){
				return root;
			}else{
				throw new Exception("Invalid input");
			}
		}
		int rootInorder = startIn; 
		while(rootInorder <= endIn && inorder[rootInorder] != rootValue){
			rootInorder++;
		}
		if(rootInorder == endIn && rootValue != inorder[rootInorder]){
			throw new Exception("Invalid input");
		}
		int leftLen = rootInorder - startIn;
		if(leftLen > 0){
			Node<T> leftNode = rebuildCore(startPre+1,startPre+leftLen,preorder,startIn,rootInorder-1,inorder);
			root.setLeft(leftNode);
		}
		if(leftLen < endPre - startPre){
			Node<T> rightNode = rebuildCore(startPre+leftLen+1,endPre,preorder,rootInorder+1,endIn,inorder);
			root.setRight(rightNode);
		}
		return root;
	}
	
	
	public <T> void layerOrder(Node<T> root ){
		if(root == null) return;
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node<T> node = queue.poll();
			System.out.print(node.getData()+",");
			if(node.getLeft() != null){
				queue.add(node.getLeft());
			}
			if(node.getRight() != null){
				queue.add(node.getRight());
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Integer[] preOrder = new Integer[]{1,2,4,7,3,5,6,8};
		Integer[] inOrder = new Integer[]{4,7,2,1,5,3,8,6};
		BinaryTree bTree = new BinaryTree();
		Node<Integer> root = bTree.rebuildTree(preOrder, inOrder);
		bTree.layerOrder(root);
	}

}
