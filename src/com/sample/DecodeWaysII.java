package com.sample;

import java.util.Arrays;

public class DecodeWaysII {
	public static void main(String[] args) {
		DecodeWaysII d = new DecodeWaysII();
		System.out.println(d.numDecodings("*0"));
	}

	long dp[];
	long mod = (long) Math.pow(10, 9) + 7;

	public int numDecodings(String s) {

		int n = s.length();
		dp = new long[n + 1];
		Arrays.fill(dp, -1);
		StringBuilder str = new StringBuilder(s);
		long r = justDoIt(str, n, 0);
		int ans = (int) (r % mod);
		return ans;
	}

	private long justDoIt(StringBuilder s, int n, int v) {
		if (v >= n) {
			return 1;
		}
		if (dp[v] != -1)
			return dp[v];

		long m = 0;
		if (s.charAt(v) == '0')
			return m;
		
		for (int i = v; i < Math.min(v + 2, n); i++) {
			
			if (i > v && s.charAt(i) == '0') {
				if (s.charAt(v) == '*') {
					m += justDoIt(s, n, i + 1) * 2;
				} else if (ok(s.charAt(v), s.charAt(i))) {
					m += justDoIt(s, n, i + 1);
				}

			} else {
				// System.out.println(v + " " + i);
				int c = check(s, v, i + 1);
				int h = 0;
				if (v == i)
					h = calculate(s.charAt(v), '#');
				else
					h = calculate(s.charAt(v), s.charAt(i));
				if (c > 0 && h > 0) {
					m += justDoIt(s, n, i + 1) * h;

				} else if ((i > v && ok(s.charAt(v), s.charAt(i))) || i == v) {
					m += justDoIt(s, n, i + 1);
				}
			}

		}
		dp[v] = m % mod;

		return m % mod;
	}

	private boolean ok(char a, char b) {
		if (a > '2')
			return false;
		if (a == '2' && b > '6')
			return false;

		return true;
	}

	private int calculate(char a, char b) {
		if (a == '*' && b == '*')
			return 15;
		if (a == '2' && b == '*')
			return 6;
		if (a > '2' && b == '*')
			return 0;
		if (a == '1' && b == '*')
			return 9;
		if (a == '*' && b <= '9' && b >= '7')
			return 1;
		if (a == '*' && b >= '1' && b <= '9')
			return 2;
		if (a == '*' && b == '#')
			return 9;

		return 0;
	}

	private int check(StringBuilder s, int a, int b) {
		int c = 0;
		for (int i = a; i < b; i++) {
			if (s.charAt(i) == '*')
				c++;
		}

		return c;
	}
}
