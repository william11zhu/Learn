package com.learn.basic.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��������ת������
 * ������ӳ���������
 * ������ӳ���������
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
	 * �ݹ�
	 * @param tNode
	 */
	public void mirror(TreeNode tNode){
		//����
		if(tNode == null) return;
		//Ҷ�ӽ��
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
	 * ����������ǵݹ鷽ʽ����������
	 * 1���жϵ�ǰ����Ƿ�Ϊ�գ���Ϊ�շ���
	 * 2������Ϊ�գ�����ǰ���������
	 * 3��ȡ��βԪ��
	 * 4����ȡ��ǰԪ�ص��ӽ�㣬������
	 * 5������ǰԪ�ص��ӽ�㲻Ϊ����������
	 * 6���ظ�3~5��ֱ������Ϊ�ա�
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
