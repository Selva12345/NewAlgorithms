package com.sample;

import java.util.Arrays;

public class BestTimetoBuyandSellStockwithTransactionFee {
	public static void main(String[] args) {
		BestTimetoBuyandSellStockwithTransactionFee b = new BestTimetoBuyandSellStockwithTransactionFee();
		int[] prices = { 1, 3, 10, 3 };

		int fee = 3;
		System.out.println(b.maxProfit(prices, fee));
	}

	int dp[][];

	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		dp = new int[n][2];
		for(int d[]:dp)
		Arrays.fill(d, -1);
		
		return calcProfit(prices, fee, 0, 0);
	}

	public int calcProfit(int[] prices, int fee, int opt, int s) {

		if (s == prices.length) {
			return 0;
		}
		if (dp[s][opt] != -1) {
			return dp[s][opt];
		}
		int m = 0;
		for (int i = s; i < prices.length; i++) {
			
			
			if (opt == 0) {
				//System.out.println(i+" "+opt+" ");
				m = Math.max(calcProfit(prices, fee, 1, i + 1) - prices[i], m);
				
			} else if (opt == 1) {
				//System.out.println(i+" "+opt);
				m = Math.max((calcProfit(prices, fee, 0, i + 1) + prices[i]) - fee, m);
			}
		}
		//System.out.println(s+" "+opt+" "+m);
		dp[s][opt] = m;
		return m;
	}
}
