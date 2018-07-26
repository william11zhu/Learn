package com.learn.basic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	private int data;
	private TreeNode leftNode;
	private TreeNode rightNode;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public TreeNode() {
	}

	public TreeNode(int data) {
		this.data = data;
	}
}

public class BinaryTree2 {

	private TreeNode rootNode;

	public TreeNode getRootNode() {
		return rootNode;
	}

	/**
	 * 连续数组构建出来的二叉树必然是完全二叉树
	 * 
	 * @param data
	 */
	public BinaryTree2(int[] data) {
		rootNode = createTree(rootNode, data, 0);
		// rootNode = createTree(data);
	}

	/**
	 * 递归方式构建二叉树
	 * 
	 * @param tNode
	 * @param data
	 * @param index
	 * @return
	 */
	private TreeNode createTree(TreeNode tNode, int[] data, int index) {
		// 剔除数组中为null或与null等价的其他类型的值
		if (index >= data.length || data[index] == 0)
			return null;
		// 创建根
		tNode = new TreeNode(data[index]);
		// 创建左子树
		TreeNode leftNode = createTree(tNode.getLeftNode(), data, 2 * index + 1);
		// 设置根的左子树,左子树的编号（下标）为2*index+1
		tNode.setLeftNode(leftNode);
		// 创建右子树
		TreeNode rightNode = createTree(tNode.getRightNode(), data, 2 * index + 2);
		// 设置根的右子树,右子树的编号（下标）为2*index+2
		tNode.setRightNode(rightNode);
		// 返回根
		return tNode;
	}

	/**
	 * 循环的方式构建二叉树
	 * 
	 * @param data
	 * @return
	 */
	private TreeNode createTree(int[] data) {
		// 将所有数据生成结点
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		for (int value : data) {
			TreeNode node = new TreeNode(value);
			// 剔除数组中为null或与null等价的其他类型的值
			if (value == 0) {
				node = null;
			}
			nodeList.add(node);
		}

		// 链接所有结点构成树,当length为偶数时，最后一个结点没有处理
		for (int i = 0; 2 * i + 2 < data.length; i++) {
			TreeNode node = nodeList.get(i);
			TreeNode leftNode = nodeList.get(2 * i + 1);
			TreeNode rightNode = nodeList.get(2 * i + 2);
			node.setLeftNode(leftNode);
			node.setRightNode(rightNode);
		}

		// 当数组长度为偶数时，单独处理最后一个叶子结点，
		// 因其编号为奇数则结点必然是左结点
		if (nodeList.size() % 2 == 0) {
			int index = nodeList.size() / 2 - 1;
			nodeList.get(index).setLeftNode(nodeList.get(index * 2 + 1));
		}
		// 设置根结点，根结点必然为数组中的第一个元素
		return nodeList.get(0);
	}

	public void preOrder(TreeNode tNode) {
		if (tNode == null)
			return;
		System.out.print(tNode.getData() + ",");
		preOrder(tNode.getLeftNode());
		preOrder(tNode.getRightNode());
	}

	public void layerOrder() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.getData() + ",");
			if (temp.getLeftNode() != null) {
				queue.add(temp.getLeftNode());
			}
			if (temp.getRightNode() != null) {
				queue.add(temp.getRightNode());
			}
		}

	}

	public static void main(String... args) {
		BinaryTree2 bTree = new BinaryTree2(new int[] { 1, 2, 3, 4, 5, 6, 7, 0, 8, 9, 10 });
		bTree.layerOrder();

	}

}
