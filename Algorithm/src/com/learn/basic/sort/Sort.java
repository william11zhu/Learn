package com.learn.basic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Sort {
	
	/**
	 * 一、冒泡排序：
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
	 * 二、桶排序：计数排序的升级，空间比计数排序节约不少
	 * 1、获取最大值、最小值，计算桶的数量
	 * 2、创建桶并初始化
	 * 3、遍历待排序列，计算每个元素所在桶的编号，并放入对应的桶中
	 * 4、对每个桶中对元素进行排序
	 * 5、按顺序取出所有桶中对元素，按顺序放入原序列中
	 * 时间复杂度:O(n)
	 * 空间复杂度:O(n)
	 * @param data
	 */
	public void buckketSort(int[] data) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<data.length;i++) {
			if(max < data[i]) {
				max = data[i];
			}
			if(min > data[i]) {
				min = data[i];
			}
		}
		
		//桶的数量
		int bucketNum = (max - min) / data.length +1;
		//创建桶并初始化
		ArrayList<ArrayList<Integer>> bucket  = new ArrayList<ArrayList<Integer>>(bucketNum);
		for(int j =0;j<bucketNum;j++) {
			bucket.add(new ArrayList<Integer>());
		}
		
		//遍历待排序列，将元素放入桶中
		for(int k=0;k<data.length;k++) {
			//桶的第一个元素经过计算是有序的
			int num = (data[k] - min) / data.length;
			bucket.get(num).add(data[k]);
		}
		
		//对桶中元素进行排序
		for(int t =0;t<bucketNum;t++) {
			Collections.sort(bucket.get(t));
		}
		
		//取出桶中元素，按顺序放入原序列
		int dataIndex = 0;
		for(int s = 0; s<bucketNum;s++) {
			if(bucket.get(s) != null) {
				for (Integer num : bucket.get(s)) {
					data[dataIndex++] = num;
				}
			}
		}
	}
	
	/**
	 * 三、计数排序:典型的空间换时间算法，空间浪费严重
	 * 1、寻找序列中的最大值max
	 * 2、开辟max+1新空间temp
	 * 3、遍历待排序列，
	 * 4、当前遍历到的值为val，将temp中下标为val位置的值加1
	 * 5、定义一个指针指向data的初始位置
	 * 6、遍历temp，若temp中的值大于0，则将当前temp下标k放入data数组中，temp中的元素减1，直到temp中的元素等于0
	 * 7、向后移动指针
	 * 时间复杂度：O(n)
	 * 空间复杂度:O(n)
	 * @param data
	 */
	public void countingSort(int[] data) {
		int max = 0;
		//寻找最大值
		for(int i = 0;i<data.length;i++) {
			if(max < data[i]) {
				max = data[i];
			}
		}
		
		//开辟临时序列，以便存放待排序列中对元素；
		//临时数组对下标为原数组中对值，
		//临时数组中对值为原数组中元素个数
		int[] temp = new int[max+1];
		for(int j=0;j<data.length;j++) {
			int index = data[j];
			temp[index]++;
		}
		
		//根据临时数组的下标和值，对原数组中对序列进行重排
		int sortedIndex = 0;
		for(int k = 0;k<temp.length;k++) {
			int dataIndex = temp[k];
			while(dataIndex > 0) {
				data[sortedIndex] = k;
				dataIndex--;
				sortedIndex++;
			}
		}
		
	}
	
	/**
	 *四、堆排序
	 *1、构建堆
	 *2、将叶子结点与堆顶交换
	 *3、重新调整堆，使堆保持大根堆/小根堆
	 *4、重复2-3，直到遍历完所有元素
	 *时间复杂度:O(nlogn)
	 *空间复杂度:O(1)
	 * @param data
	 */
	public void heapSort(int[] data) {
		buildHeap(data);
		
		System.out.println(Arrays.toString(data));
		
		for(int i=data.length-1;i > 0;i--) {
			swap(data, 0, i);
			heapify(data, 0,i);
			
			
		}
	}
	
	/**
	 * 构造大根堆
	 * 1、只需遍历数组前一半，后一半均为叶子结点
	 * @param data
	 */
	private void buildHeap(int[] data) {
		//遍历所有根结点
		for(int i=data.length/2;i>=0;i--) {
			heapify(data, i,data.length);
		}
	}
	
	
	/**
	 * 堆调整
	 * 1、在根和左右子结点中找出最小的结点
	 * 2、如果最小的结点不为根，则和根交换
	 * 3、继续调整交换过的子树
	 * 4、未交换过的子树不满足要求会在最外层的循环中遍历到。
	 * @param data
	 * @param index
	 */
	private void heapify(int[] data,int index,int len) {
		
		int maxIndex = index;
		if(2*index+1 < len && data[index] < data[2*index+1]) {
			maxIndex = 2*index+1;
		}
		if(2*index+2<len && data[maxIndex] < data[2*index+2]) {
			maxIndex = 2*index+2;
		}
		
		if(maxIndex != index) {
			swap(data, index, maxIndex);
			heapify(data,maxIndex,len);
		}
	}
	
	/**
	 * 五、插入排序：选择元素插入到指定位置
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
	 * 六、归并排序：
	 * 1、将待排序列分组
	 * 2、对组内进行排序
	 * 3、合并排序结果
	 * 时间复杂度:O(nlogn)
	 * 空间复杂度:O(n)
	 * @param data
	 */
	
	public void mergeSort(int[] data) {
		int[] temp = new int[data.length];
		mergeSort(data,0,data.length-1,temp);
	}
	
	/**
	 * 递归分组
	 * @param source
	 * @param start
	 * @param end
	 * @param target
	 */
	private void mergeSort(int[] source,int start,int end,int[] target) {
		if(start >= end) return;
		int mid = (start+end)/2;
		mergeSort(source,start,mid,target);
		mergeSort(source, mid+1, end, target);
		merge(source,start,mid,end,target);
	}
	
	/**
	 * 合并有序组
	 * @param source
	 * @param start
	 * @param mid
	 * @param end
	 * @param target
	 */
	private void merge(int[] source,int start,int mid,int end,int[] target) {
		int left = start;//左组指针
		int right = mid+1;//右组指针
		int index = 0; //临时数组指针
		//比较左右组对元素，将较小者加入临时数组
		while(left <= mid && right <=end ) {
			if(source[left] <= source[right]) {
				target[index] = source[left];
				index++;
				left++;
			}else {
				target[index] = source[right];
				index++;
				right++;
			}
		}
		
		//将左组中剩下的元素放入临时数组
		while(left <= mid) {
			target[index] = source[left];
			left++;
			index++;
		}
		
		//将右组中剩下的元素放入临时组
		while(right <= end) {
			target[index] = source[right];
			index++;
			right++;
		}
		
		//将临时数组的有序元素覆盖原组中无序的序列
		index = 0;
		while(start <= end) {
			source[start] = target[index];
			start++;
			index++;
		}
	}
	
	/**
	 * 七、快速排序:以左数为基数
	 * 时间复杂度:O(nlogn)
	 * 空间复杂度:O(1)
	 * @param data
	 */
	public void quickSort(int[] data ,int left ,int right) {
			if(left > right) return;
			int i = left;
			int j = right;
			
			while(i != j) {
				while(i < j && data[j] >= data[left]) {
					j--;
				}
				while(i < j && data[i] <= data[left]) {
					i++;
				}
				
				if(i < j)
					swap(data, i, j);
			}
			swap(data, i, left);
			quickSort(data, left, i-1);
			quickSort(data,i+1, right);
	}
	
	/**
	 * 八、基数排序
	 * 1、获取待排序列中对最大值
	 * 2、从低位到高位依次进行计数排序或桶排序
	 * 时间复杂度:O(n)
	 * 空间复杂度:O(n)
	 * @param data
	 */
	public void radixSort(int[] data) {
		int max = Integer.MIN_VALUE;
		for (int i : data) {
			if(max < i) {
				max = i;
			}
		}
		
		int mod = 10;
		int dev = 1;
		//将数字分解，从低位开始进行桶排序
		for(;dev<max;mod = mod *10,dev=dev*10) {
			/*
			 * 以下使用桶排序
			 */
			//初始化桶
			ArrayList<ArrayList<Integer>> radix = new ArrayList<ArrayList<Integer>>(10);
			for(int s=0;s< 10 ;s++) {
				radix.add(new ArrayList<Integer>());
			}
			
			for(int k=0;k<data.length;k++) {
				int bucket = data[k] % mod /dev;
				radix.get(bucket).add(data[k]);
			}
			
			int sortedIndex = 0;
			for(int m=0;m<radix.size();m++) {
				for(int n=0;n<radix.get(m).size();n++) {
					data[sortedIndex++] = radix.get(m).get(n);
				}
			}
		}
	}
	
	/**
	 * 九、希尔排序：改版插入排序，将数据分为gap个组，组内使用插入排序
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
	 * 十、选择排序：选择最小的放入指定位置
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
//		int[] data = new int[] {77, 76, 42, 52, 86, 27, 90, 9, 3, 62};
		int[] data = new int[10];
		Random random = new Random();
		for(int i=0;i<data.length;i++) {
			data[i] = random.nextInt(1000);
		}
		System.out.println(Arrays.toString(data));
		sort.radixSort(data);
		System.out.println(Arrays.toString(data));
	}
}
