package com.sample;

import java.util.ArrayList;
import java.util.List;

public class CatAndMouse {
	public static void main(String[] args) {
		CatAndMouse c = new CatAndMouse();
		int g[][] = {{4},{2,3,5},{1,5,3},{1,2},{0},{1,2}};
		System.out.println(c.catMouseGame(g));
	}

	List<Integer> graph[];

	public int catMouseGame(int[][] g) {
		int n = g.length;
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			int a[] = g[i];
			List<Integer> val = graph[i];
			for (int c : a) {
				val.add(c);
			}
		}
		boolean visited[][] = new boolean[n][n];
		int ans = justDoIt(1, 2, visited, 0, -1, -1);
		return ans;
	}

	private int justDoIt(int mouse, int cat, boolean visited[][], int opt, int mp, int cp) {
		if (mouse == 0)
			return 1;
		if (mouse == cat)
			return 2;
		if (visited[mouse][cat] == true)
			return 0;

		int val = 0;
		if (opt == 0) {
			val = mouse;
			visited[val][cat] = true;
		} else {
			val = cat;
			visited[mouse][val] = true;
		}

		int res = -1;

		for (int a : graph[val]) {
			if (opt == 0) {
				if (mp == a)
					continue;
				int v1 = justDoIt(a, cat, visited, 1, val, cp);
				if (v1 == 1) {
					return v1;
				}
				if (res != 0)
					res = v1;
			} else if (opt == 1) {
				if (cp == a)
					continue;
				int v2 = justDoIt(mouse, a, visited, 0, mp, val);
				if (v2 == 2) {
					return v2;
				}
				if (res != 0)
					res = v2;
			}

		}
		return res;
	}
}
