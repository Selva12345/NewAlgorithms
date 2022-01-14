package com.sample;

import java.util.PriorityQueue;

public class MinimumCosttoReachDestinationinTime {
	public static void main(String[] args) {
		MinimumCosttoReachDestinationinTime m=new MinimumCosttoReachDestinationinTime();
		int [][]edges= {{0,1,100}};
		int []pass= {2,5};
		System.out.println(m.minCost(100, edges, pass));
	}

	Integer graph[][];

	public int minCost(int maxTime, int[][] edges, int[] passingFees) {
		int n = edges.length;
		graph = new Integer[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			int edge[] = edges[i];
			graph[edge[0]][edge[1]] = edge[2];
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.offer(new int[] { 0, 0, passingFees[0] });
		while (!pq.isEmpty()) {
			int temp[] = pq.poll();

			if (temp[1] > maxTime)
				continue;

			if (temp[0] == n)
				return temp[2];

			for (int i = 0; i < n + 1; i++) {
				if (graph[temp[0]][i] == null)
					continue;
				int m = graph[temp[0]][i];
				pq.offer(new int[] { i, temp[1] + m, temp[2] + passingFees[i] });
			}
		}
		return -1;
	}
}
