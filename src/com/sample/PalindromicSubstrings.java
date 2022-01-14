package com.sample;

public class PalindromicSubstrings {
	public static void main(String[] args) {
		PalindromicSubstrings p=new PalindromicSubstrings();
		System.out.println(p.countSubstrings("aaa"));
	}

	public int countSubstrings(String s) {
		int n = s.length();
		int dp[][] = new int[n][n];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < n - i + 1; j++) {
				int k = i + j - 1;
				if (i == 1) {
					dp[j][k] = 1;
				} else if (s.charAt(j) == s.charAt(k) && check(j, k, s)) {
					dp[j][k] = (dp[j + 1][k] + dp[j][k - 1] + 1) - dp[j + 1][k - 1];
				} else {
					dp[j][k] = (dp[j + 1][k] + dp[j][k - 1]) - dp[j + 1][k - 1];
				}

			}

		}
		return dp[0][n - 1];
	}

	public boolean check(int i, int j, String s) {
		StringBuilder sb = new StringBuilder(s.substring(i, j + 1));

		if (sb.reverse().toString().equals(s.substring(i, j + 1))) {
			return true;
		}
		return false;
	}

}
