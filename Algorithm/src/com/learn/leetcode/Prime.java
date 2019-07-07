package com.learn.leetcode;

public class Prime {
	public int eulrPrimes(int n){
		int count = 0;
		boolean[] isPrime = new boolean[n];
		int[] primes = new int[n];
		for(int i= 2;i<n;i++){
			if(!isPrime[i]){
				primes[count] = i;
				count++;
			}
			for(int j=0;j<count && i*primes[j] < n;j++){
				isPrime[i*primes[j]] = true;
				if(i % primes[j] == 0){ 
					System.out.println(i+","+primes[j]+","+i*primes[j]);
					break;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String... args){
		Prime p = new Prime();
		int count = p.eulrPrimes(10);
		System.out.println("��������Ϊ:"+count);
	}
}
