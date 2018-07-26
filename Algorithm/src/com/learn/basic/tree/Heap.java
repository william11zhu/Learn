package com.learn.basic.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Heap {
	private int[] data;
	private int length;
	private int capacity;

	public int[] getData() {
		int[] temp = new int[length];
		for(int i = 0;i<length;i++) {
			temp[i] = data[i];
		}
		return temp;
	}
	
	public Heap() {
		length = 0;
		this.capacity = 10;
		data = new int[capacity];
	}

	public Heap(int capacity) {
		length = 0;
		this.capacity = capacity;
		data = new int[capacity];
	}

	public int top() {
		if(data == null || length == 0) {
			throw new NullPointerException("当前堆为空");
		}
		return data[0];
	}
	
	public void setTop(int val) {
		if(data == null) {
			throw new NullPointerException("当前堆为空");
		}
		data[0] = val;
	}
	
	public void MinHeap(int[] data) {
		this.data = data;
		length = data.length;
		capacity = length;
		createMinHeap();
	}

	public void createMinHeap() {
		for (int i = (length - 1) / 2; i >= 0; i--) {
			shiftDown(data, i);
		}
	}

	/**
	 * 增加结点
	 * @param val
	 */
	public void add(int val) {
		dilatation();
		length++;
		data[length-1] = val;
		shiftUp(data, length-1);

	}

	/**
	 * 扩容
	 */
	private void dilatation() {
		if (length == capacity) {
			int[] temp = data;
			capacity = capacity + 5;
			data = new int[capacity];
			for (int i = 0; i < temp.length; i++) {
				data[i] = temp[i];
			}
		}
	}

	public void shiftDown() {
		shiftDown(data, 0);
	}
	
	/**
	 * 小根堆结点下沉
	 * 
	 * @param data
	 * @param index
	 */
	private void shiftDown(int[] data, int index) {
		if (index >= length)
			return;
		int minIndex = 2 * index + 1;
		// 左子超出范围，则右子必然超出范围，所以直接返回
		if (minIndex >= length)
			return;
		// 比较左右子大小，取最小的
		if (2 * index + 2 < length && data[minIndex] > data[2 * index + 2]) {
			minIndex = 2 * index + 2;
		}
		// 左右子中最小的与根相比，若比根小则交换，并调整子树
		if (data[minIndex] < data[index]) {
			swap(index, minIndex);
			shiftDown(data, minIndex);
		}
	}
	
	public void shiftUp() {
		shiftUp(data, length-1);
	}
	
	/**
	 * 小根堆向上调整
	 * @param data
	 * @param index
	 */
	private void shiftUp(int[] data,int index) {
		int parentIndex = (index-1) /2;
		if(parentIndex < 1) return;
		if(data[parentIndex] > data[index]) {
			swap(parentIndex, index);
			shiftUp(data, parentIndex);
		}
		
	}

	private void swap(int father, int son) {
		int temp = data[father];
		data[father] = data[son];
		data[son] = temp;
	}

	public void layerOrder() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(data[0]);
		int index = 0;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp + ",");
			if (2 * index + 1 < length) {
				queue.add(data[2 * index + 1]);
			}
			if (2 * index + 2 < length) {
				queue.add(data[2 * index + 2]);
			}
			index++;
		}
	}

	public static void main(String... args) {
//		Heap heap = new Heap();
//		heap.MinHeap(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 });
//		heap.layerOrder();
//		System.out.println();
//		for (int val : heap.data) {
//			System.out.print(val + ",");
//		}
		
		Heap heap = new Heap();
		for(int i=9;i>=0;i--) {
			heap.add(9-i);
		}
		heap.layerOrder();
		System.out.println();
		for (int val : heap.data) {
			System.out.print(val + ",");
		}
	}
}
