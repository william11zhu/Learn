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
	 * �������鹹�������Ķ�������Ȼ����ȫ������
	 * 
	 * @param data
	 */
	public BinaryTree2(int[] data) {
		rootNode = createTree(rootNode, data, 0);
		// rootNode = createTree(data);
	}

	/**
	 * �ݹ鷽ʽ����������
	 * 
	 * @param tNode
	 * @param data
	 * @param index
	 * @return
	 */
	private TreeNode createTree(TreeNode tNode, int[] data, int index) {
		// �޳�������Ϊnull����null�ȼ۵��������͵�ֵ
		if (index >= data.length || data[index] == 0)
			return null;
		// ������
		tNode = new TreeNode(data[index]);
		// ����������
		TreeNode leftNode = createTree(tNode.getLeftNode(), data, 2 * index + 1);
		// ���ø���������,�������ı�ţ��±꣩Ϊ2*index+1
		tNode.setLeftNode(leftNode);
		// ����������
		TreeNode rightNode = createTree(tNode.getRightNode(), data, 2 * index + 2);
		// ���ø���������,�������ı�ţ��±꣩Ϊ2*index+2
		tNode.setRightNode(rightNode);
		// ���ظ�
		return tNode;
	}

	/**
	 * ѭ���ķ�ʽ����������
	 * 
	 * @param data
	 * @return
	 */
	private TreeNode createTree(int[] data) {
		// �������������ɽ��
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		for (int value : data) {
			TreeNode node = new TreeNode(value);
			// �޳�������Ϊnull����null�ȼ۵��������͵�ֵ
			if (value == 0) {
				node = null;
			}
			nodeList.add(node);
		}

		// �������н�㹹����,��lengthΪż��ʱ�����һ�����û�д���
		for (int i = 0; 2 * i + 2 < data.length; i++) {
			TreeNode node = nodeList.get(i);
			TreeNode leftNode = nodeList.get(2 * i + 1);
			TreeNode rightNode = nodeList.get(2 * i + 2);
			node.setLeftNode(leftNode);
			node.setRightNode(rightNode);
		}

		// �����鳤��Ϊż��ʱ�������������һ��Ҷ�ӽ�㣬
		// ������Ϊ���������Ȼ������
		if (nodeList.size() % 2 == 0) {
			int index = nodeList.size() / 2 - 1;
			nodeList.get(index).setLeftNode(nodeList.get(index * 2 + 1));
		}
		// ���ø���㣬������ȻΪ�����еĵ�һ��Ԫ��
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
