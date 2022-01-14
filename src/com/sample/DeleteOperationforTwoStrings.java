package com.sample;

public class DeleteOperationforTwoStrings {
	public static void main(String[] args) {
		DeleteOperationforTwoStrings d = new DeleteOperationforTwoStrings();
		System.out.println(d.minDistance("sea", "eat"));
	}

	public int minDistance(String word1, String word2) {
		int dp[][] = new int[word1.length() + 1][word2.length() + 1];
		return minDist(word1, word2, 0, 0, dp);
		
	}

	public int minDist(String word1, String word2, int a, int b, int dp[][]) {

		if (a == word1.length() || b == word2.length()) {
			if (a == word1.length()) {
				return Math.abs(b - word2.length());
			} else
				return Math.abs(a - word1.length());
		}
		int min = Integer.MAX_VALUE, m = 0;
		if (word1.charAt(a) == word2.charAt(b)) {
			min = Math.min(minDist(word1, word2, a + 1, b + 1, dp), min);
			return min;
		}
		int m1 = 0, m2 = 0;
		m1 += minDist(word1, word2, a + 1, b, dp);

		min = Math.min(m1, min);

		m2 += minDist(word1, word2, a, b + 1, dp);

		min = Math.min(m2, min);

		dp[a][b] = min;

		return min + 1;
	}
}
