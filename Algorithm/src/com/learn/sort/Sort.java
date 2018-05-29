package com.learn.sort;

public class Sort {
	
	/**
	 * 冒泡排序：
	 * 1、比较相邻的两个元素
	 * 2、若与期望序列不一直则交换
	 * 时间复杂度:O(n^2)
	 * 空间复杂度:O(1)
	 * @param data
	 */
	public void bubbleSort(int[] data) {
		for(int i=0;i<data.length;i++) {
			for(int j=0;j<data.length-1-i;j++) {
				if(data[j] > data[j+1]) {
					swap(data, j, j+1);
				}
			}
		}
	} 
	
	/**
	 * 插入排序：选择元素插入到指定位置
	 * 1、选择带排序到序列到第一个元素为基数
	 * 2、从待排序列中最后一个元素开始与基数比较
	 * 3、若比基数大，则移动该元素，插入到小于等于该元素的元素位置之后
	 * 4、若不比基数大，则不移动
	 * 时间复杂度:O(n^2)
	 * 空间复杂度:O(1)
	 * @param data
	 */
	public void insertSort(int[] data) {
		for(int i=1;i<data.length;i++) {
			int temp = data[i];
			int j = i;
			//寻找位置，若不是当前位置则后移元素。
			while(j > 0 && temp < data[j-1]) {
				data[j] = data[j-1];
				j--;
			}
			data[j] = temp;
		}
	}
	
	/**
	 * 希尔排序：改版插入排序，将数据分为gap个组，组内使用插入排序
	 * 时间复杂度:O(n*log2n)
	 * 空间复杂度:O(1)
	 * @param data
	 */
	public void shellSort(int[] data) {
		for(int gap = data.length/2;gap > 0;gap = gap/2) {
			for(int i=gap;i<data.length;i=i+gap) {
				int j = i;
				int temp = data[i];
				while(j >= gap && temp < data[j-gap]) {
					data[j] = data[j-gap];
					j = j - gap;
				}
				data[j] = temp;
			}
		} 
	}
	
	/***
	 * 选择排序：选择最小的放入指定位置
	 * 时间复杂度:O(n^2)
	 * 空间复杂度:O(1)
	 * @param data
	 */
	public void selectSort(int[] data) {
		for(int i=0;i<data.length;i++) {
			int minIndex = i;
			for(int j=i+1;j<data.length;j++) {
				if(data[minIndex]>data[j]) {
					minIndex = j;
				}
			}
			swap(data, i, minIndex);
		}
	}
	
	
	
	
	/**
	 * 交换
	 * @param data
	 * @param i
	 * @param j
	 */
	public void swap(int[] data,int i,int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	
	public static void main(String... args) {
		Sort sort = new Sort();
		int[] data = new int[] {9,8,7,6,5,4,3,2,1};
		sort.shellSort(data);
		for (int i : data) {
			System.out.print(i+",");
		}
	}
}
