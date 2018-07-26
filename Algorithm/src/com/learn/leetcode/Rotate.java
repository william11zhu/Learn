package com.learn.leetcode;

public class Rotate {
	 public void rotate(int[][] matrix) {
	        //沿主对角线互换
	        for(int i=0;i<matrix.length;i++){
	            for(int j=i;j<matrix[i].length;j++){
	                int tmp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = tmp;
	            }
	        }
	        //沿行中轴线对折
	        for(int k=0;k<matrix.length/2;k++){
	            for(int m=0;m<matrix[k].length;m++){
	                int tmp = matrix[m][k] ;
	                matrix[m][k] = matrix[m][matrix.length-1-k];
	                matrix[m][matrix.length-1-k] = tmp;
	            }
	        }
	    }
	 
	 public static void main(String... args){
		 int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		 Rotate rotate = new Rotate();
		 rotate.rotate(matrix);
		 
		 for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	 }
}
