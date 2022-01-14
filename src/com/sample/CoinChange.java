package com.sample;

public class CoinChange {
	public static void main(String[] args) {
		CoinChange c = new CoinChange();
		int coins[] = { 2,5,10,1 };
		int amnt = 27;
		System.out.println(c.coinChange(coins, amnt));
	}

	public int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int dp[][] = new int[n][n];
		return countCoin(coins, amount, 0);

	}

	private int countCoin(int[] coins, int amount, int i) {

		if (amount == 0)
			return 0;
		else if (amount < 0)
			return Integer.MAX_VALUE;
		else if (i == coins.length)
			return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int p = countCoin(coins, amount, i + 1);
		if (p != Integer.MAX_VALUE) {
			return p;
		}
		int r = countCoin(coins, amount - coins[i], 0);
		if (r != Integer.MAX_VALUE) {
			r += 1;
		}
		min = Math.min(r, min);

		return r;
	}
}
