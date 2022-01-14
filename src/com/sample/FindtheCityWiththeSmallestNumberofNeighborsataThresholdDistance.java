package com.sample;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
	public static void main(String[] args) {
		FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance f = new FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance();
		// 5
		// [{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}]
		// 2
		
		
		
		int n = 5;
		int edges[][] = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
		int distanceThreshold = 2;
		System.out.println(f.findTheCity(n, edges, distanceThreshold));
		TreeMap<Integer,Integer>   range=new TreeMap<>();
		range.put(6,8);
		range.put(11,14);
		SortedMap<Integer, Integer>  tr=range.subMap(6, 8);
	
		tr.clear();
	}

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int graph[][] = new int[n][n];
		for (int g[] : graph)
			Arrays.fill(g, -1);
		for (int ed[] : edges) {
			graph[ed[0]][ed[1]] = ed[2];
			graph[ed[1]][ed[0]] = ed[2];
		}
		
		int res=Integer.MAX_VALUE;
		int val=0;
		for (int i = 0; i < n; i++) {
			int count[] = new int[n];
			Arrays.fill(count, Integer.MAX_VALUE);
			boolean visited[] = new boolean[n];
			visited[i] = true;
			count[i]=0;
			q.offer(new int[] { i, 0 });
			int a=0;
			while (!q.isEmpty()) {
				int nxt[] = q.poll();
				visited[nxt[0]] = true;
				for (int j = 0; j < n; j++) {
					if (graph[nxt[0]][j] == -1 || visited[j])
						continue;
					if (nxt[1] + graph[nxt[0]][j] > distanceThreshold)
						continue;
					if (count[j] > nxt[1] + graph[nxt[0]][j]) {
						count[j] = nxt[1] + graph[nxt[0]][j];
					}
					q.offer(new int[] { j, nxt[1] + graph[nxt[0]][j] });
				}

			}
			for(int c:count) {
				if(c!=0&&c< Integer.MAX_VALUE)a++;
			}
			if(res>=a) {
				res=a;
				val=i;
			}
			
		}
		return val;
	}
}
