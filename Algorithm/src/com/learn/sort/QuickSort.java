package com.learn.sort;

import java.util.Random;

public class QuickSort {
	public <T extends Comparable<T>> int partition(T[] data,int start,int end,int length) throws Exception{
		if(data == null || start < 0 || end > length || length <=0){
			throw new Exception("Invalid parameters");
		}
		Random random = new Random(length);
		int index = random.nextInt();
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
	
	
	
}
