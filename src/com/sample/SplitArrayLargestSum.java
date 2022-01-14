package com.sample;

public class SplitArrayLargestSum {
	public static void main(String[] args) {
		SplitArrayLargestSum s = new SplitArrayLargestSum();
		int nums[] = { 7, 2, 5, 10, 8 };
		s.splitArray(nums, 2);
	}

	int dp[][], p = 0;

	public int splitArray(int[] nums, int m) {
		int n = nums.length;
		dp = new int[n][m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m + 1; j++) {
				dp[i][j] = -1;
			}
		}
		p = m;
		int[] prefix = new int[n];
		int sum = 0;
		prefix[0] = nums[0];
		sum = nums[0];
		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] + nums[i];
			sum += nums[i];
		}
		if (m == 1)
			return prefix[n - 1];

		int min = justDoIt(prefix, 0, 0, n, sum);
		return min;
	}

	private int justDoIt(int[] prefix, int m, int start, int n, int total) {
		if (m == p - 1&&total>0) {
			return total;
		}
		if (dp[start][m] != -1) {
			return dp[start][m];
		}
		int max =0;
		int min = Integer.MAX_VALUE;
		for (int i = start; i < n; i++) {
			max=splitValue(start, i, prefix);
			max = Math.max(justDoIt(prefix, m + 1, i + 1, n, total - max),max);
			min = Math.min(max, min);
		}
		dp[start][m] = min;
		return dp[start][m];
	}

	private int splitValue(int start, int end, int sum[]) {
		start--;
		if (start < 0)
			return sum[end];
		return sum[end] - sum[start];
	}

}
