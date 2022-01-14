package com.sample;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedislands {
	public static void main(String[] args) {
		NumberOfClosedislands n=new NumberOfClosedislands();
		int g[][]= {{1,1,0,1,1,1,1,1,1,1},
					{0,0,1,0,0,1,0,1,1,1},
					{1,0,1,0,0,0,1,0,1,0},
					{1,1,1,1,1,0,0,1,0,0},
					{1,0,1,0,1,1,1,1,1,0},
					{0,0,0,0,1,1,0,0,0,0},
					{1,0,1,0,0,0,0,1,1,0},
					{1,1,0,0,1,1,0,0,0,0},
					{0,0,0,1,1,0,1,1,1,0},
					{1,1,0,1,0,1,0,0,1,0}};
		System.out.println(n.closedIsland(g));
	}

	public int closedIsland(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		int a[] = { -1, 0, 1, 0 };
		int b[] = { 0, 1, 0, -1 };
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && grid[i][j] == 0) {
					visited[i][j] = true;
					q.offer(new int[] { i, j });
				}
				int c = 0;
				while (!q.isEmpty()) {

					int[] temp = q.poll();
					System.out.println(temp[0] + "," + temp[1] + " --> ");
					if (c == 0)c = 1;
					for (int k = 0; k < 4; k++) {
						int x = temp[0] + a[k];
						int y = temp[1] + b[k];

						if (isSafe(n, m, x, y) && !visited[x][y] && grid[x][y] == 0) {
							visited[x][y] = true;
							q.offer(new int[] { x, y });
							
							System.out.print(x + " " + y);
						} else if (!isSafe(n, m, x, y)) {
							c = -1;
						}
					}

				}
				if (q.isEmpty() && c == 1)
					count++;

			}
		}
		return count;
	}

	private boolean isSafe(int n, int m, int i, int j) {
		if (i >= 0 && i < n && j >= 0 && j < m)
			return true;

		return false;
	}
}
