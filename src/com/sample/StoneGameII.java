package com.sample;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class StoneGameII {
	public static void main(String[] args) {
		StoneGameII s=new StoneGameII();
		System.out.println(s.stoneGameII(new int[] {9,2,2,8,3,7,9,6}));
	}

	int dp[][];

	public int stoneGameII(int[] piles) {
		int n = piles.length;
		dp = new int[n][2];
		int sum[] = new int[n];
		sum[0] = piles[0];
		int total = piles[0];
		for (int a[] : dp)
			Arrays.fill(a, -1);
		
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + piles[i];
			total += piles[i];
		}
		TreeMap<Integer, Integer> tr=new TreeMap<>();
		PriorityQueue<Integer> pq=new PriorityQueue<>();

		return justDoIt(sum, n, 1, 1, 0);

	}

	private int justDoIt(int[] piles, int n, int m, int t, int s) {
		if(s>=n) {
			if(t==1)return 0;
			else  return 0;
		}
		
		if (s<n&&dp[s][t] != -1) {
			//return dp[s][t];
		}
		int a = Integer.MAX_VALUE, b = Integer.MIN_VALUE;
		for (int i = 0; i<(2 * m); i++) {
			if(i+s>=n) {
				continue;
			}
			if(s==1&&i==1) {
				System.out.println();
			}
			if(s==4&&m==2&&t==1) {
				System.out.println();
			}
			if (t == 0) {
				a = Math.min(justDoIt(piles, n, Math.max(i+1, m), 1, s + i+1), a);
			} else {
				b = Math.max(justDoIt(piles, n, Math.max(i+1, m), 0, s + i+1) + getValue(piles, s, s + i), b);
			}
			

		}
		if (t == 0) {
			dp[s][t] = a;
			return a;
		} else {
			dp[s][t] = b;
			return b;
		}

	}

	private int getValue(int[] piles, int s, int e) {
		if(s==0)return piles[e];
		
		return piles[e] - piles[s-1];
	}
}
