package com.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberofWaystoPaintNGrid {
	public static void main(String[] args) {
		NumberofWaystoPaintNGrid n = new NumberofWaystoPaintNGrid();
		System.out.println(n.numOfWays(2));
	}

	long mod = (long) (Math.pow(10, 9) + 7);

	long dp[][][];
	Map<String, Long> mp;

	public int numOfWays(int n) {
		dp = new long[n][3][3];
		mp = new HashMap<>();
		for (long b[][] : dp) {
			for (long a[] : b) {
				Arrays.fill(a, -1);
			}

		}
		int m = 3;
		long ans = 0L;
		int[][] visited = new int[n][m];
		for (int a[] : visited)
			Arrays.fill(a, -1);
		for (int i = 0; i < 3; i++) {
			visited[0][0] = i;
			ans += justDoIt(n, m, 0, 0, visited, i) % mod;
		}

		return (int) ans;
	}

	int x[] = { -1, 0, 1, 0 };
	int y[] = { 0, 1, 0, -1 };

	private long justDoIt(int n, int m, int p, int q, int[][] visit, int color) {
		if (p >= n - 1 && q >= m - 1) {
			return 1;
		}

		if (q >= m)
			p++;
		q = q % 3;
		String k = formKey(visit, p, q, n, m);
		k+=p+""+q+""+color+"";
		if (mp.containsKey(k)) {
			 return mp.get(k);
		}
		System.out.println(p + " " + q);
		long a = 0, b = 0, c = 0;

		if (check(visit, n, m, p, q, color)) {
			visit[p][q] = color;
			if (q + 1 >= m)
				p++;
			q = (q + 1) % 3;
			for (int i = 0; i < 3; i++) {

				if (check(visit, n, m, p, q, i)) {

					a = justDoIt(n, m, p, q, visit, i) % mod;
					String key = formKey(visit, p, q, n, m);
					key+=p+""+q+""+i+"";
				    mp.put(key,a);
					
					b += a;
				}

			}
			visit[p][q] = -1;
		}

		return b;
	}

	private String formKey(int[][] visit, int p, int q, int n, int m) {
		String key = "";
		for (int i = 0; i < 4; i++) {
			int a = x[i] + p;
			int b = y[i] + q;
			if (isSafe(n, m, a, b)) {
				key += visit[a][b] + "";

			} else {
				key += -1 + "";
			}
		}
		return key;
	}

	private boolean check(int[][] visit, int n, int m, int p, int q, int c) {
		for (int i = 0; i < 4; i++) {
			int a = x[i] + p;
			int b = y[i] + q;
			if (isSafe(n, m, a, b)) {
				if (visit[a][b] == c) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isSafe(int n, int m, int i, int j) {
		if (i >= 0 && i < n && j >= 0 && j < m)
			return true;

		return false;
	}
}
