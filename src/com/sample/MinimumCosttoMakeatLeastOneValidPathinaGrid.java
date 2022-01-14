package com.sample;

import java.util.PriorityQueue;

public class MinimumCosttoMakeatLeastOneValidPathinaGrid {
	public static void main(String[] args) {
		MinimumCosttoMakeatLeastOneValidPathinaGrid m=new MinimumCosttoMakeatLeastOneValidPathinaGrid();
		int grid[][]= {{1,3,3,3},{2,2,1,2},{4,3,3,4},{3,2,2,3},{3,2,1,3},{4,1,4,3},{3,3,1,2}};
		System.out.println(m.minCost(grid));
	}

	public int minCost(int[][] grid) {
		int n = grid.length;

		int m = grid[0].length;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.offer(new int[] { 0, 0, 0 });
		boolean visited[][] = new boolean[n][m];
		int x[] = { -1, 0, 1, 0 };
		int y[] = { 0, 1, 0, -1 };
		
		while (!pq.isEmpty()) {
				
			int[] val = pq.poll();
			if(val[0]==4&&val[1]==2) {
				System.out.println();
			}
			if(visited[val[0]][val[1]])continue;
			
			visited[val[0]][val[1]] = true;
			
			if (val[0] == n - 1 && val[1] == m - 1) {
				return val[2];
			}
			for (int i = 0; i < 4; i++) {
				int a = x[i] + val[0];
				int b = y[i] + val[1];
				if (!isSafe(a, b, n, m)) {
					continue;
				}
				if (grid[val[0]][val[1]] == 1 && a == val[0] && b == val[1] + 1 && !visited[a][b]) {
					pq.offer(new int[] { a, b, val[2] });
					
				} else if (grid[val[0]][val[1]] == 2 && a == val[0] && b == val[1] - 1 && !visited[a][b]) {
					pq.offer(new int[] { a, b, val[2] });
					
				} else if (grid[val[0]][val[1]] == 3 && a == val[0] + 1 && b == val[1] && !visited[a][b]) {
					pq.offer(new int[] { a, b, val[2] });
					
				} else if (grid[val[0]][val[1]] == 4 && a == val[0] - 1 && b == val[1] && !visited[a][b]) {
					pq.offer(new int[] { a, b, val[2] });
					
				} else if (!visited[a][b]) {
					pq.offer(new int[] { a, b, val[2] + 1 });
					
				}
			}

		}

		return -1;
	}

	public boolean isSafe(int a, int b, int n, int m) {
		if (a >= 0 && a < n && b >= 0 && b < m) {
			return true;
		}
		return false;
	}
}
