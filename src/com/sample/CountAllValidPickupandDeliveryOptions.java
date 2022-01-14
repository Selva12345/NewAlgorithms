package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountAllValidPickupandDeliveryOptions {
	public static void main(String[] args) {
		CountAllValidPickupandDeliveryOptions c=new CountAllValidPickupandDeliveryOptions();
		System.out.println(c.countOrders(4));
	}

	long mod = (long) Math.pow(10, 9) + 7;
	long dp[][];

	public int countOrders(int n) {
		dp = new long[n+1][n+1];
		for(long[]a:dp)
		Arrays.fill(a, -1);
		
		List<Integer> p = new ArrayList<>();
		List<Integer> d = new ArrayList<>();
		long value = justDoIt(n,n);
		long r = value % mod;
		return (int) r;
	}

	private long justDoIt(int n1,int n2) {
		if ( n1== 0&&n2==0) {
			return 1;
		}
		if (dp[n1][n2] != -1) {
			return dp[n1][n2];
		}
		long t = 0;
		for (int i = 1; i <= n1; i++) {
			t += justDoIt(n1 - 1,n2);
		}
		if (n2 > 0) {
			for (int i = 0; i <n2-n1 ; i++) {
				t += justDoIt(n1,n2-1);
			}
		}
		dp[n1][n2] = t % mod;
		return t % mod;
	}
}
