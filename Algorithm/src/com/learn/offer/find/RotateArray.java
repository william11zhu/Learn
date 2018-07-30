package com.learn.offer.find;

public class RotateArray {
	
	public <T extends Comparable<T>> T findMin(T[] data) throws Exception{
		if(data == null || data.length <= 0){
			throw new Exception("Invalid input");
		}
		int left = 0;
		int right = data.length-1;
		int mid = left;
		while(data[left].compareTo(data[right]) > 0){
			if(right - left == 1 ){
				mid = right;
				break;
			}
			mid = (left + right) / 2;
			if(data[mid].compareTo(data[left]) >=0){
				left = mid;
			}else if(data[mid].compareTo(data[right]) <= 0){
				right = mid;
			}
		}
		
		return data[mid];
	}
}
