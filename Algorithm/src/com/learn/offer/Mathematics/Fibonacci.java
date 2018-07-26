package com.learn.offer.Mathematics;

public class Fibonacci {
	public long fibonacci(int n){
		long first = 0;
		long second = 1;
		long result = 0;
		if(n <= 0){
			return first;
		}
		if(n == 1){
			return second;
		}
		for(int i=2;i< n;i++){
			result = first + second;
			first = second;
			second = result;
		}	
			
		return result;
	}
	
	
	public static void main(String[] args){
		Fibonacci f = new Fibonacci();
		System.out.print(f.fibonacci(5));
	}
}
