package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CutOffTreesforGolfEvent {
	public static void main(String[] args) {
		CutOffTreesforGolfEvent c = new CutOffTreesforGolfEvent();
		List<List<Integer>> forest = new ArrayList<>();
		forest.add(Arrays.asList(54,64,24,69));
		forest.add(Arrays.asList(86,61,68,79));
		forest.add(Arrays.asList(66,92,89,94));
		forest.add(Arrays.asList(83,22,46,47));
		forest.add(Arrays.asList(89,18,25,60));
		System.out.println(c.cutOffTree(forest));
	}

	public int cutOffTree(List<List<Integer>> forest) {
		int n = forest.size();
		if (n == 0)
			return 0;

		int m = forest.get(0).size();
		int mat[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = forest.get(i).get(j);
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
		pq.offer(new int[] { 0, 0, 0, forest.get(0).get(0) });
		int x[] = { -1, 0, 1, 0 };
		int y[] = { 0, 1, 0, -1 };
		int ans = 0;
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		mat[0][0] = 1;
		while (!pq.isEmpty()) {
			int cur[] = pq.poll();
			mat[cur[0]][cur[1]] = 1;
			boolean flag=false;
			for (int i = 0; i < 4; i++) {
				int a = x[i] + cur[0];
				int b = y[i] + cur[1];

				if (isSafe(a, b, n, m) && mat[a][b] > 0 && !visited[a][b]) {
					visited[a][b] = true;
					flag=true;
					pq.offer(new int[] { a, b, cur[2] + 1, mat[a][b] });
				}
			}
			if(!flag) {
				ans+=cur[2];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] > 0) {
					return -1;
				}
			}
		}
		return ans;
	}

	public boolean isSafe(int i, int j, int n, int m) {
		if (i >= 0 && i < n && j >= 0 && j < m)
			return true;

		return false;
	}
}
