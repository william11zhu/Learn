package com.learn.basic.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树反转（镜像）
 * 左子树映射成右子树
 * 右子树映射成左子树
 * @author ZHJJ
 *
 */
public class MirrorTree {
	private BinaryTree2 bTree;
	private TreeNode rootNode;
	
	public MirrorTree(int[] data){
		bTree = new BinaryTree2(data);
		rootNode = bTree.getRootNode();
	}
	
	
	public void mirror(){
		mirror(rootNode);
	}
	
	/**
	 * 递归
	 * @param tNode
	 */
	public void mirror(TreeNode tNode){
		//空树
		if(tNode == null) return;
		//叶子结点
		if(tNode.getLeftNode() == null && tNode.getRightNode() == null)return;
		TreeNode leftNode = tNode.getLeftNode();
		TreeNode rightNode = tNode.getRightNode();
		tNode.setLeftNode(rightNode);
		tNode.setRightNode(leftNode);
		mirror(leftNode);
		mirror(rightNode);
	}
	
	
	public void mirrorNotRecursive(){
		mirrorNotRecursive(rootNode);
	}
	
	/**
	 * 二叉树镜像非递归方式，借助队列
	 * 1、判断当前结点是否为空，若为空返回
	 * 2、若不为空，将当前结点加入队列
	 * 3、取队尾元素
	 * 4、获取当前元素的子结点，并交换
	 * 5、若当前元素的子结点不为空则加入队列
	 * 6、重复3~5，直到队列为空。
	 * @param tNode
	 */
	public void mirrorNotRecursive(TreeNode tNode){
		if(tNode == null) return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(tNode);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			TreeNode leftNode = node.getLeftNode();
			TreeNode rightNode = node.getRightNode();
			node.setLeftNode(rightNode);
			node.setRightNode(leftNode);
			if(leftNode != null){
				queue.add(leftNode);
			}
			if(rightNode != null){
				queue.add(rightNode);
			}
		}
	}
	
	public void layerOrder(){
		layerOrder(rootNode);
	}
	
	public void layerOrder(TreeNode tNode){
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(tNode);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			System.out.print(temp.getData()+",");
			if(temp.getLeftNode() !=null){
				queue.add(temp.getLeftNode());
			}
			if(temp.getRightNode() != null){
				queue.add(temp.getRightNode());
			}
		}
		
	}

	public static void main(String... args){
		int[] data = new int[]{1,2,3,4,5,6,7,8,9};
		MirrorTree mTree = new MirrorTree(data);
		mTree.layerOrder();
		mTree.mirrorNotRecursive();
		System.out.println();
		mTree.layerOrder();
	}
}
