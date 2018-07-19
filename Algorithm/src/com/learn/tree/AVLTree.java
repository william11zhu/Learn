package com.learn.tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<E extends Comparable<E>> {

	private Node<E> root;

	public AVLTree() {
		this.root = null;
	}

	public void insert(E e) {
		root = this.insert(e, root);
	}

	public void remove(E e) {
		this.root = this.remove(e, this.root);
	}

	/**
	 * 插入节点，生成平衡二叉树
	 * 
	 * @param e
	 * @param avlTree
	 * @return
	 */
	public Node<E> insert(E e, Node<E> subRoot) {
		if (subRoot == null) {
			return new Node<E>(e);
		}
		int compareResult = e.compareTo(subRoot.getData());
		if (compareResult < 0) {
			// e < avlTree.getData(); 放到左子树
			// 递归插入到合适的位置
			Node<E> temp = insert(e, subRoot.getLeft());
			subRoot.setLeft(temp);

			if (height(subRoot.getLeft()) - height(subRoot.getRight()) > 1) {
				// 判断左子树的高度不平衡
				if (e.compareTo(subRoot.getLeft().getData()) < 0) {
					// e插入到左子树的左子树上，符合LL，使用右旋调整
					subRoot = rightRotate(subRoot);
				} else {
					// e插入到左子树的右子树上，符合LR，使用先左旋再右旋调整
					subRoot = leftAndRightRotate(subRoot);
				}
			}
		} else {
			// e >= subRoot.getData();放到右子树
			Node<E> temp = insert(e, subRoot.getRight());
			subRoot.setRight(temp);
			if (height(subRoot.getRight()) - height(subRoot.getLeft()) > 1) {
				if (e.compareTo(subRoot.getRight().getData()) > 0) {
					subRoot = leftRotate(subRoot);
				} else {
					subRoot = rightAndLeftRotate(subRoot);
				}
			}
		}
		int subRootHeight = getMaxHeight(subRoot.getLeft(), subRoot.getRight());
		subRoot.setHeight(subRootHeight);
		return subRoot;
	}

	public Node<E> remove(E e, Node<E> subRoot) {
		if (subRoot == null) {
			return null;
		}
		int compareResult = e.compareTo(subRoot.getData());
		if (compareResult < 0) {
			//在左子树上继续查找，并删除
			Node<E> temp = remove(e, subRoot.getLeft());
			subRoot.setLeft(temp);
			//从左子树上删除，可能引起左子树高度降低，判断右子树是否大于左子树的高度+平衡因子
			if (height(subRoot.getRight()) - height(subRoot.getLeft()) > 1) {
				Node<E> rightSon = subRoot.getRight();
				//判断左子树的右子树高度是否大于左子树的高度
				if (height(rightSon.getLeft()) > height(rightSon.getRight())) {
					//左子树的左子树高度大于左子树的右子树高度，树的形状属于：RL
					subRoot = rightAndLeftRotate(subRoot);
				} else {
					//左子树的左子树高度小于等于左子树的右子树高度，树的形状属于：RR
					subRoot = leftRotate(subRoot);
				}

			} else {
				int subRootHeight = getMaxHeight(subRoot.getLeft(), subRoot.getRight());
				subRoot.setHeight(subRootHeight);
			}
		} else if (compareResult > 0) {
			//在右子树上查找并删除
			Node<E> temp = remove(e, subRoot.getRight());
			subRoot.setRight(temp);
			//可能引起右子树高度降低，判断右子树是否平衡，
			if (height(subRoot.getLeft()) - height(subRoot.getRight()) > 1) {
				//右子树不平衡
				Node<E> leftSon = subRoot.getLeft();
				if (height(leftSon.getRight()) > height(leftSon.getLeft())) {
					//右子树的高度右子树高度大于右子树的左子树高度，树的形状符合：LR
					subRoot = leftAndRightRotate(subRoot);
				} else {
					//右子树的高度右子树高度小于等于右子树的左子树高度，树的形状符合：LL
					subRoot = rightRotate(subRoot);
				}

			} else {
				int subRootHeight = getMaxHeight(subRoot.getLeft(), subRoot.getRight());
				subRoot.setHeight(subRootHeight);
			}
		} else {
			//已找到待删除节点，如果左右子树不为空，则使用当前节点，中序遍历的前继或后继节点替换待删除节点，最后删除叶子节点
			if (subRoot.getLeft() != null && subRoot.getRight() != null) {
				if (height(subRoot.getLeft()) > height(subRoot.getRight())) {
					//如果左子树的高度大于右子树的高度，则在左子树中找最大值替换待删节点，并删除替换后的叶子节点
					Node<E> maxNode = findMax(subRoot.getLeft());
					subRoot.setData(maxNode.getData());
					remove(maxNode.getData(), subRoot.getLeft());
				} else {
					//如果左子树的高度小于等于右子树的高度，则在右子树中找最小值替换待删节点，并删除替换后的叶子节点
					Node<E> minNode = findMin(subRoot.getRight());
					subRoot.setData(minNode.getData());
					remove(minNode.getData(), subRoot.getRight());
				}
			} else {
				subRoot = subRoot.getLeft() != null ? subRoot.getLeft() : subRoot.getRight();
			}
		}
		return subRoot;
	}

	private Node<E> findMax(Node<E> subRoot) {
		while (subRoot.getRight() != null) {
			subRoot = subRoot.getRight();
		}
		return subRoot;
	}

	private Node<E> findMin(Node<E> subRoot) {
		while (subRoot.getLeft() != null) {
			subRoot = subRoot.getLeft();
		}

		return subRoot;
	}

	/**
	 * 右旋：左子树的调整 d b b ===> a d a c c
	 * 
	 * @param avlRoot
	 * @return
	 */
	private Node<E> rightRotate(Node<E> subRoot) {
		// 获取子树根的左子树
		Node<E> newRoot = subRoot.getLeft();
		// 根的左子树设为子节点的右子树
		subRoot.setLeft(newRoot.getRight());
		// 子节点的右子树
		newRoot.setRight(subRoot);
		// 重新计算子树高度

		int avlRootHeight = getMaxHeight(subRoot.getLeft(), subRoot.getRight());
		subRoot.setHeight(avlRootHeight);

		int newRootHeight = getMaxHeight(newRoot.getLeft(), newRoot.getRight());
		newRoot.setHeight(newRootHeight);
		return newRoot;
	}

	/**
	 * 左旋 b d d ===> b e c e c
	 * 
	 * @param subRoot
	 * @return
	 */
	private Node<E> leftRotate(Node<E> subRoot) {
		Node<E> newRoot = subRoot.getRight();
		subRoot.setRight(newRoot.getLeft());
		newRoot.setLeft(subRoot);
		int avlRootHeight = getMaxHeight(subRoot.getLeft(), subRoot.getRight());
		subRoot.setHeight(avlRootHeight);

		int newRootHeight = getMaxHeight(newRoot.getLeft(), newRoot.getRight());
		newRoot.setHeight(newRootHeight);
		return newRoot;
	}

	/**
	 * 先左旋再右旋 c c b a ===> b ===> a c b a
	 * 
	 * @param subRoot
	 * @return
	 */
	private Node<E> leftAndRightRotate(Node<E> subRoot) {
		subRoot = leftRotate(subRoot);
		return rightRotate(subRoot);
	}

	/**
	 * 先右旋再左旋 a a b c ===> b ===> a c b c
	 * 
	 * @param subRoot
	 * @return
	 */
	private Node<E> rightAndLeftRotate(Node<E> subRoot) {
		subRoot = rightRotate(subRoot);
		return leftRotate(subRoot);
	}

	private int getMaxHeight(Node<E> left, Node<E> right) {
		int leftHeight = height(left);
		int rightHeight = height(right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	private int height(Node<E> node) {
		return node == null ? -1 : node.getHeight();
	}

	public void levelOrder() {
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		Node<E> root = this.root;
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			System.out.print(node.getData() + ",");
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
	}

	public static void main(String... args) {
		AVLTree<Integer> avlTree = new AVLTree<>();
		for (int i = 9; i > -1; i--) {
			avlTree.insert(i);
		}
		avlTree.levelOrder();
		System.out.println();
		avlTree.remove(7);
		avlTree.remove(9);
		avlTree.levelOrder();

	}
}
