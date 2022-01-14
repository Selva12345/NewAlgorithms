package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class OddEvenJump {
	public static void main(String[] args) {
		OddEvenJump o=new OddEvenJump();
		int arr[]= {2,3,1,1,4};
		System.out.println(o.oddEvenJumps(arr));
	}

	int dp[][];

	public int oddEvenJumps(int[] arr) {
		int n = arr.length;
		dp = new int[n][3];
		for (int a[] : dp)
			Arrays.fill(a, -1);
		TreeMap<Integer, List<Integer>> tr = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			if (!tr.containsKey(arr[i])) {
				tr.put(arr[i], new ArrayList<Integer>());
			}
			tr.get(arr[i]).add(i);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			int a=justDoIt(arr, n, i, 1, tr, arr[i]);
			res += a;
			System.out.println(res);
		}
		return res;
	}

	private int justDoIt(int[] arr, int n, int i, int c,TreeMap<Integer, List<Integer>> tr , int s) {
		if (i >= n-1) {
			return 1;
		}
		if (dp[i][c] != -1) {
			return dp[i][c];
		}
		int res = 0;
		if (c % 2 == 1) {
			int index = getOddJump(tr, i, s);
			if (index != -1)
				res = justDoIt(arr, n, index, 2, tr, arr[index]);
			else
				res = 0;
		} else if (c % 2 == 0) {
			int index = getEvenJump(tr, i, s);
			if (index != -1)
				res=justDoIt(arr, n, index, 1, tr, arr[index]);
			else
				res = 0;
		}
		dp[i][c] = res;
		return res;
	}

	private int getOddJump(TreeMap<Integer, List<Integer>> tr , int i, int s) {
		int index = 0;
		int j = 0;
		while (index <= i) {
			Integer v = tr.ceilingKey(s + j);
			if (v == null)
				return -1;
			for(int p:tr.get(v)) {
				if(i<p) {
					index=p;
					break;
				}
			}
				
			j++;
		}
        
		return index;
	}

	private int getEvenJump(TreeMap<Integer, List<Integer>> tr, int i, int s) {
		int index = 0;
		int j = 0;
		while (index <= i) {
			Integer v = tr.floorKey(s - j);
			if (v == null)
				return -1;
			for(int p:tr.get(v)) {
				if(i<p) {
					index=p;
					break;
				}
			}
			j++;
		}
		return index;
	}
}
