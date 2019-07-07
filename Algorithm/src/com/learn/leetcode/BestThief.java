package com.learn.leetcode;

import java.awt.Robot;

public final class BestThief {
	private int rob(int[] nums , int start , int end){
        if(start > end) return 0;
        if(start == end){
            if(start >=0 && start < nums.length)
                return nums[start];
            else 
                return 0;
        }
        int max = 0;
        int maxIndex = 0;
        for(int i = start;i <= end;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return max + rob(nums,start,maxIndex-2) + rob(nums,maxIndex+2,end);
    }
	
	public static void main(String[] args){
		BestThief bt = new BestThief();
		int[] nums = new int[]{4,4,0,0};
		int result = bt.rob(nums, 0, nums.length-1);
		System.out.println(result);
	}
}
