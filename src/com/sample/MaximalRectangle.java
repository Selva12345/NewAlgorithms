package com.sample;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		MaximalRectangle m=new MaximalRectangle();
		char mat[][]= {{'1','0','0','0','1'},{'1','1','0','1','1'},{'1','1','1','1','1'}};
		System.out.println(m.maximalRectangle(mat));
	}

	public int maximalRectangle(char[][] mat) {
		int n = mat.length;
		if (n == 0)
			return 0;
		int m = mat[0].length;
		if (n == 1 && m == 1) {
			if (mat[0][0] == '1')
				return 1;
			else
				return 0;
		}
		int matrix[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = mat[i][j] - '0';
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[j][i] == 0) {
					matrix[j][i] = 0;
				} else if (j > 0) {
					matrix[j][i] += matrix[j - 1][i];
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(largestRectanle(matrix[i]), max);
		}
		
		return max;
	}

	private int largestRectanle(int arr[]) {
		int n = arr.length;
		int left[] = new int[n];
		int right[] = new int[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			if (!st.isEmpty()) {
				left[i] = st.peek() + 1;
			} else {
				left[i] = 0;
			}
			st.push(i);
		}
		Stack<Integer> st2 = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			while (!st2.isEmpty() && arr[st2.peek()] >= arr[i]) {
				st2.pop();
			}
			if (!st2.isEmpty()) {
				right[i] = st2.peek() - 1;
			} else {
				right[i] = n-1;
			}
			st2.push(i);
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			int diff =(right[i]-left[i])+1;
			max = Math.max(diff * arr[i], max);
		}
		return max;
	}

}
