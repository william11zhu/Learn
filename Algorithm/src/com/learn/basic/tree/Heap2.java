package com.learn.basic.tree;

public class Heap2 {
	private int[] heap;
	private int length;
	private int capacity;

	/**
	 * 创建指定容量的堆
	 * 
	 * @param capcity
	 */
	public Heap2(int capacity) {
		this.length = 0;
		this.capacity = capacity;
		this.heap = new int[capacity];
	}

	private void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}

	/**
	 * 堆上浮
	 */
	public void shiftUp() {
		for (int i = length - 1; i > 1; i = i / 2) {
			if (heap[i] < heap[i / 2]) {
				swap(i, i / 2);
			}
		}
	}

	/**
	 * 堆下沉
	 */
	public void shiftDown(int index) {
		for (int i = index; 2 * i <= length; i = 2 * i) {
			if (2 * i < length && heap[2 * i + 1] < heap[2 * i]) {
				if (heap[i] > heap[2 * i + 1]) {
					swap(i, 2 * i + 1);
				}
			} else {
				return;
			}
		}
	}

	/**
	 * 向堆中加入节点
	 * 
	 * @param node
	 */
	public void push(int node) throws IndexOutOfBoundsException {
		if (length == capacity) {
			throw new IndexOutOfBoundsException("堆已满，无法添加");
		}
		heap[length] = node;
		shiftUp();
	}

	/**
	 * 弹出指定节点
	 * 
	 * @param index
	 * @return
	 */
	public int pop(int index) {
		int temp = heap[index];
		heap[index] = heap[length - 1];
		heap[length - 1] = temp;
		length--;
		shiftDown(index);
		return temp;
	}

	/**
	 * 取堆顶
	 * 
	 * @return
	 */
	public int top() {
		return heap[0];
	}

	/**
	 * 堆排
	 */
	public void sort() {

	}
}
