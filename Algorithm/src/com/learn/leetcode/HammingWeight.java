package com.learn.leetcode;

public class HammingWeight {
	public int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
	
	public static void main(String... args){
		HammingWeight hw = new HammingWeight();
		int count = hw.hammingWeight(10);
		System.out.println(count);
	}
}
