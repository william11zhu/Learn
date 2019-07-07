package com.learn.leetcode;

import java.util.Arrays;

public class MergeArrays {
	
	public static void main(String... args){
		MergeArrays ma = new MergeArrays();
		int[] nums1 = new int[]{1,2,3,0,0,0};
		int[] nums2 = new int[]{2,5,6};
		ma.merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i] = nums2[i]; 
        }
        
        qiuckSort(nums1,0,m+n-1);
        
    }
    
    private void qiuckSort(int[] nums,int left,int right){
        if(left > right) return;
        int base = left;
        int i = left;
        int j = right;
        while(i != j){
            while(i < j && nums[j] >= nums[base]){
                j--;
            }
            
            while(i < j && nums[i] <= nums[base]){
                i++;
            }
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        
        if(i == j){
            int temp = nums[i];
            nums[i] = nums[base];
            nums[base] = temp;
        }
        qiuckSort(nums,left,i-1);
        qiuckSort(nums,i+1,right);
    }
}
