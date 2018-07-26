package com.learn.leetcode;

import java.io.IOException;
import java.util.Arrays;

public class MatrixZero {
	public void setZeroes(int[][] matrix) {
		int len1 = matrix.length;
		if (len1 == 0)
			return;
		int len2 = matrix[0].length;
		if (len2 == 0)
			return;
		int row = -1, col = -1;
		for (int i = 0; i < len1; i++){
			for (int j = 0; j < len2; j++) {
				if (matrix[i][j] == 0) {
					row = i;
					col = j;
				}
			}
		}
		if (row == -1)
			return;
		for (int i = 0; i < len1; i++){
			for (int j = 0; j < len2; j++) {
				if (matrix[i][j] == 0 && i != row && j != col) {
					matrix[i][col] = 0;
					matrix[row][j] = 0;
				}
			}
		}
		for (int i = 0; i < len1; i++){
			for (int j = 0; j < len2; j++) {
				if (i != row && j != col) {
					if (matrix[i][col] == 0)
						matrix[i][j] = 0;
					else if (matrix[row][j] == 0)
						matrix[i][j] = 0;
				}
			}
		}
		int index = -1;
		while (++index < len1){
			matrix[index][col] = 0;
		}
		index = -1;
		while (++index < len2){
			matrix[row][index] = 0;
		}
	}

	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static String int2dArrayToString(int[][] array) {
		if (array == null) {
			return "null";
		}
		if (array.length == 0) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder("[");
		for (int[] item : array) {
			sb.append(Arrays.toString(item));
			sb.append(",");
		}

		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		new MatrixZero().setZeroes(matrix);
		String out = int2dArrayToString(matrix);
		System.out.print(out);
	}
}
