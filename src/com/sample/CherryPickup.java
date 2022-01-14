package com.sample;

import java.util.LinkedList;
import java.util.Queue;

public class CherryPickup {
	public static void main(String[] args) {
		CherryPickup c=new CherryPickup();
		int [][]grid= {{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}};
		System.out.println(c.cherryPickup(grid));
	}
	public int cherryPickup(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int dp[][] = new int[n][m];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			if (grid[i][0] == -1) {
				dp[i][0] = -1;
				continue;
			}
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < m; i++) {
			if (grid[0][i] == -1) {
				dp[0][i] = -1;
				continue;
			}
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		justDoIt(grid, n, m, dp);
		int max = dp[n - 1][n - 1];
		if(max<0)return 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { n - 1, m - 1, max });
		grid[n - 1][m - 1] = 0;
		int x[] = { -1, 0 };
		int y[] = { 0, -1 };
		while (!q.isEmpty()) {
			int a[] = q.poll();
			for (int i = 0; i < 2; i++) {
				int u = x[i] + a[0];
				int v = y[i] + a[1];
				if (u < 0 || u >= n || v < 0 || v >= m)
					continue;
				if (dp[u][v] == a[2] - 1) {
					q.offer(new int[] { u, v, a[2] - 1 });
					grid[u][v] = 0;
					break;
				}
			}
		}
		dp = new int[n][m];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < m; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		justDoIt(grid, n, m, dp);
		int nmax = dp[n - 1][n - 1];
		return max + nmax;
	}

	private void justDoIt(int[][] grid, int n, int m, int dp[][]) {

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (grid[i][j] == -1||(dp[i - 1][j]==-1&&dp[i][j - 1]==-1)) {
					dp[i][j] = -1;
					continue;
				}
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
	}
}
