package com.sample;

import java.util.Arrays;

public class NumberOfWaysOfCuttingAPizza {
	public static void main(String[] args) {
		NumberOfWaysOfCuttingAPizza n = new NumberOfWaysOfCuttingAPizza();
		System.out.println(n.ways(new String[] { "A..A", "AAA.", "...A" }, 4));
	}

	long dp[][][];
long mod=(long)Math.pow(10, 9)+7;
	public int ways(String[] pizza, int k) {
		int n = pizza.length;
		int m = pizza[0].length();
		int mat[][] = new int[n][m];
		dp = new long[n][m][k];
		for (long[][] c : dp) {
			for(long d[]:c)Arrays.fill(d, -1);
		}
			
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				char a = pizza[i].charAt(j);
				if (a == 'A')
					mat[i][j] = 1;
			}
		}
		 long r=justDoIt(n, m, mat, 0, 0, k - 1);
		 return (int)r;
	}

	private long justDoIt(int n, int m, int mat[][], int p, int q, int k) {

		if (k == 0) {
			return 1L;
		}
		if (p >= n || q >= m) {
			return 0;
		} // fddd55ttdfi86tr []]]]piop]
		if (dp[p][q][k] != -1) {
			//System.out.println("");
			return dp[p][q][k];
		}
		long t = 0;
		for (int i = p; i < n; i++) {
			if (containsAppleRow(p, q, i, mat) && check(i + 1, q, n, m, mat)) {

				long s = justDoIt(n, m, mat, i + 1, q, k - 1);
				if (s >= 1) {
					t += s;
				}
			}
		}
		for (int i = q; i < m; i++) {
			if (containsAppleColumn(p, q, i, mat) && check(p, i + 1, n, m, mat)) {
				long s = justDoIt(n, m, mat, p, i + 1, k - 1);
				if (s >= 1) {
					t += s;
				}
			}
		}
		//System.out.println(p+" "+q+" "+t%mod);
		dp[p][q][k] = t%mod;
		return t%mod;
	}

	private boolean check(int p, int q, int n, int m, int[][] mat) {
		for (int i = p; i < n; i++) {
			for (int j = q; j < m; j++) {
				if (mat[i][j] == 1) {
					return true;
				}
			}
		}
		return false;

	}

	private boolean containsAppleRow(int a, int b, int limit, int mat[][]) {
		for (int i = a; i <= limit; i++) {
			for (int j = b; j < mat[0].length; j++) {
				if (mat[i][j] == 1)
					return true;
			}
		}

		return false;
	}

	private boolean containsAppleColumn(int a, int b, int limit, int mat[][]) {
		for (int j = b; j <= limit; j++) {
			for (int i = a; i < mat.length; i++) {
				if (mat[i][j] == 1)
					return true;
			}

		}
		return false;
	}
}
