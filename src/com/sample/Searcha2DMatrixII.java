package com.sample;

import java.util.LinkedList;
import java.util.Queue;

public class Searcha2DMatrixII {
	public static void main(String[] args) {
		Searcha2DMatrixII s=new Searcha2DMatrixII();
		int a[][]= {{1,1}};
			//{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		System.out.println(s.searchMatrix(a, 0));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int a[] = q.poll();
			if(a[0]<0||a[1]<0)continue;
			
			if (matrix[a[0]][a[1]] == target)
				return true;
			
			int c[] = searchValueRow(a[0], a[1], matrix, target);
			int d[] = searchValueCol(a[0], a[1], matrix, target);
			if(c[0]!=a[0]||c[1]!=a[1])
			q.offer(c);
			if(d[0]!=a[0]||d[1]!=a[1])
			q.offer(d);

		}
		return false;
	}

	private int[] searchValueRow(int i, int j, int[][] matrix, int target) {
		int low = j, high = matrix[0].length-1;
		while (low <=high) {
			int mid = low + (high - low) / 2;
			if (matrix[i][mid] > target) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
	
		return new int[] { i, high };
	}

	private int[] searchValueCol(int i, int j, int[][] matrix, int target) {
		int low = i, high = matrix.length-1;
		while (low <=high) {
			int mid = low + (high - low) / 2;
			if (matrix[mid][j] > target) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return new int[] { high, j };
	}
}
