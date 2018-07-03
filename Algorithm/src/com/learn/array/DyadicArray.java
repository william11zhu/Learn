package com.learn.array;

public class DyadicArray {
	private int[][] data;
	
	public int[][] getData() {
		return data;
	}
	public void setData(int[][] data) {
		this.data = data;
	}
	
	public DyadicArray(){}
	public DyadicArray(int[][] data){
		this.data = data;
	}
	
	/**
	 * 有序二维数组中查找指定值
	 * 1、二维数组有序
	 * 2、从二维数组第一行最后一列开始
	 * 3、比当前元素小，左移一列继续
	 * 4、比当前元素大，下移一行继续
	 * @param x
	 * @return
	 */
	public boolean findX(int x){
		int col = data[0].length-1;
		for(int i=0;i<data.length;i++){
			for(int j=col;j>=0;j--){
				if(data[i][j] < x){
					break;
				}else if(data[i][j] > x){
					col--;
					continue;
				}else{
					return true;
				}
			}
		}
		
		return false;
	}

	
	public static void main(String... args){
		int[][] nums = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		DyadicArray da = new DyadicArray(nums);
		System.out.print(da.findX(0));
	}
}
