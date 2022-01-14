package com.sample;

public class MaximumSumofNonOverlappingSubarrays {
	public static void main(String[] args) {
		MaximumSumofNonOverlappingSubarrays m = new MaximumSumofNonOverlappingSubarrays();
		int nums[] = {1,2,1,2,6,7,5,1};
		int k = 2;
		System.out.println(m.maxSumOfThreeSubarrays(nums, k));
	}
	 int dp[][][];

		public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
			int n = nums.length;
			dp = new int[3][n][];
			for (int i = 1; i < n; i++) {
				nums[i] = nums[i - 1] + nums[i];
			}
			int sum[] = new int[n - k + 1];
			int dp[] = new int[n - k + 1];
			int indices[] = new int[n - k + 1];
			sum[0] = nums[k - 1];
			for (int i = k; i < n; i++) {
				sum[i - k + 1] = nums[i] - nums[i - k];
			}

			int a[] = justDoIt(sum, 0, 2, k);
			return new int [] {a[2],a[1],a[0]};
		}

		private int[] justDoIt(int[] sum, int s, int c, int k) {
			if (c < 0) {
				return new int[] { -1, -1, -1, 0 };
			}
			if (s >= sum.length) {
				return null;
			}
		
			if (dp[c] != null && dp[c][s] != null) {
				return dp[c][s];
			}
			int max = 0, r[] = { -1, -1, -1, 0 };
				int b[] = justDoIt(sum, s + k, c - 1, k);
				if (b == null) {
					dp[c][s] = r;
					return r;
				}
					
				
				int a = Math.max(b[3] + sum[s], max);
				if (max < a) {
					max = a;
					r[0]=b[0];r[1]=b[1];r[2]=b[2];r[3]=b[3];
					r[3] = max;
					r[c] = s;
				}
				int d[]=justDoIt(sum, s+ 1, c, k);
				if (d == null) {
					dp[c][s] = r;
					return r;
				}
				if(d[3]>r[3]) {
					r[0]=d[0];r[1]=d[1];r[2]=d[2];r[3]=d[3];
				}
				
			dp[c][s] = r;
			return r;
		}
}
