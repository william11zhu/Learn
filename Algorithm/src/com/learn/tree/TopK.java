package com.learn.tree;

public class TopK {
	
	private int[] data;
	public TopK(int[] data) {
		this.data = data;
	}
	
	/**
	 * 取前K大的元素，使用小根堆
	 * 1、先用前k个元素构造小根堆
	 * 2、若堆顶小于后续元素，则交换
	 * @param k
	 * @return
	 */
	public int[] getTopK(int k) {
		if(data.length <= k) {
			return data;
		}
		Heap heap = new Heap();
		for(int i=0;i<data.length;i++) {
			if(i<k) {
				heap.add(data[i]);
			}else {
				int temp = heap.top();
				if(temp < data[i]) {
					heap.setTop(data[i]);
					heap.shiftDown();
				}
			}
		}
		return heap.getData();
	}
	
	public static void main(String... args) {
		int[] data = new int[100];
		for(int i =0;i<100;i++) {
			//Random random = new Random();
			//data[i] = random.nextInt(100);
			data[i] = i;
		}
		
		
		TopK topK = new TopK(data);
		int[] temp = topK.getTopK(10);
		
		for (int i : temp) {
			System.out.print(i+",");
		}
	}
}
