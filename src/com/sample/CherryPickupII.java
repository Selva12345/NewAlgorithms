package com.sample;

public class CherryPickupII {
	public static void main(String[] args) {
		CherryPickupII c = new CherryPickupII();
		int[][] grid = { { 1, 0, 0, 0, 0, 0, 1 }, { 2, 0, 0, 0, 0, 3, 0 }, { 2, 0, 9, 0, 0, 0, 0 },
				{ 0, 3, 0, 5, 4, 0, 0 }, { 1, 0, 2, 3, 0, 0, 6 } };
		System.out.println(c.cherryPickup(grid));
	}

	int dp[][];

	public int cherryPickup(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		dp = new int[n][n];
		return justDoIt(grid, n, m, 0, 0, 0, m - 1);
	}

	int x[] = { 1, 1, 1 };
	int y[] = { -1, 0, 1 };

	private int justDoIt(int[][] grid, int n, int m, int p, int q, int u, int v) {
		if (p == n - 1 && u == n - 1) {
			return grid[p][q] + grid[u][v];
		}
		if (dp[p][u] != 0) {
			// return dp[p][u];
		}
		int max = 0;
		for (int i = 0; i < 3; i++) {
			int a = x[i] + p;
			int b = y[i] + q;
			if(!isSafe(a,b,n,m))continue;
			for (int j = 0; j < 3; j++) {
				
				int c = x[j] + u;
				int d = y[j] + v;
				if(b==d)continue;
				if (isSafe(c, d, n, m)) {
					max = Math.max(justDoIt(grid, n, m, a, b, c, d), max);
				}

			}
		}
		dp[p][u] = max;
		return max + grid[p][q] + grid[u][v];
	}

	private boolean isSafe(int i, int j, int n, int m) {
		if (i >= 0 && j >= 0 && i < n && j < m) {
			return true;
		}
		return false;
	}
}
