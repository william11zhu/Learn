package com.learn.offer.sort;

import java.util.Random;

public class QuickSort {
	public <T extends Comparable<T>> int partition(T[] data,int start,int end,int length) throws Exception{
		if(data == null || start < 0 || end > length || length <=0){
			throw new Exception("Invalid parameters");
		}
		Random random = new Random();
		//(start < index < end)
		int index = random.nextInt(end-start+1)+start;
		T temp = data[index];
		data[index] = data[end];
		data[end] = temp;
		
		int small = start -1;
		for(int i = start;i < end;i++){
			if(data[i].compareTo(data[end])< 0){
				small++;
				if(small != i){
					temp = data[small];
					data[small] = data[i];
					data[i] = temp;
				}
			}
		}
		small++;
		temp = data[small];
		data[small] = data[end];
		data[end] = temp;
		return small;
	}
	
	public <T extends Comparable<T>> void quickSort(T[] data,int start,int end) throws Exception{
		if(data == null || data.length <=0){
			return;
		}
		int length = data.length;
		int index = partition(data,start,end,length);
		if(index > start){
			quickSort(data,start,index-1);
		}
		
		if(index < end){
			quickSort(data,index+1,end);
		}
		
		//start == index == end 时是递归结束条件
	}
	
	public static void main(String[] args) throws Exception{
		QuickSort qs = new QuickSort();
		Integer[] data = new Integer[10];
		for(int i=0;i<10;i++){
			data[i] = 9-i;
			System.out.print(data[i]+",");
		}
		System.out.println();
		qs.quickSort(data, 0, data.length-1);
		
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+",");
		}
	}
	
	
}
