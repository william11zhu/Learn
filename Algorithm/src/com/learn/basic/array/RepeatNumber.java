package com.learn.basic.array;

import java.util.ArrayList;
import java.util.List;

public class RepeatNumber {
	
	/**
	 * 判断长度为n,元素分布服从0~n-1的数组中是否有重复元素。
	 * 利用数据分布特性，将下标与元素对应
	 * @param nums
	 * @return
	 */
	public boolean duplicate(int[] nums){
		if(null == nums || nums.length == 0){
			return false;
		}
		//校验数组满足题目要求,数组中的元素在0~n-1范围内
		for(int num : nums){
			if(num < 0 || num > nums.length-1){
				return false;
			}
		}
		
		for(int i=0;i<nums.length;i++){
			while(nums[i] != i){
				if(nums[i] == nums[nums[i]]){
					System.out.println(nums[i]);
					return true;
				}
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}
		return false;
	}
	
	/**
	 * 不修改数组，找出重复的数字
	 * 数组长度为n，数字范围为0~n-1
	 * 
	 * 分析：计数排序的思想
	 * 时间复杂度：O(n)
	 * 空间复杂度:O(n)
	 * @param nums
	 * @return
	 */
	public int getDuplication2(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}
		int[] buck = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			if(buck[nums[i]] > 1){
				return nums[i];
			}
			buck[nums[i]]++;
		}
		return -1;
	}
	
	public List<Integer> getRepeatDuplication(int[] nums){
		if(nums == null || nums.length == 0){
			return null;
		}
		int[] bucket = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			bucket[nums[i]]++;
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<bucket.length;i++){
			if(bucket[nums[i]]>1){
				result.add(nums[i]);
			}
		}
		return result;
	}
	
	
	/**
	 * 不修改数组，找出重复的数字
	 * 数组长度为n，数字范围为0~n-1
	 * 
	 * 分析：利用二分查找的思想，用时间换空间
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度:O(1)
	 * @param nums
	 * @return
	 */
	public int getDuplication(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}
		int start = 1;
		int end = nums.length -1;
		while(end >= start){
			int mid = ((end-start) >> 1) + start;
			int count = countRange(nums,start,mid);
			if(end == start){
				if(count > 1){
					return start;
				}else{
					break;
				}
			}
			
			if(count > mid - start + 1){
				end = mid;
			}else{
				start = mid + 1;
			}
		}
		
		return -1;
	}
	
	
	private int countRange(int[] nums,int start,int end){
		if(nums == null) return 0;
		int count = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i] >= start && nums[i] <=end){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String... args){
		RepeatNumber rn = new RepeatNumber();
		int[] nums = {2,3,1,4,2,5,3};
		rn.duplicate(nums);
		nums = new int[]{2,3,5,4,3,2,6,7};
		rn.getDuplication2(nums);
	}
}
