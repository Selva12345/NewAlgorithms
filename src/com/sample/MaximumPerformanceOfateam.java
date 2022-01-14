package com.sample;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceOfateam {
	public static void main(String[] args) {
		MaximumPerformanceOfateam m=new MaximumPerformanceOfateam();
		System.out.println(m.maxPerformance(6, new int[] {2,10,3,1,5,8}, new int[] {5,4,3,9,7,2}, 2));
	}
	 public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		 int[][] ess = new int[n][2];
	        for (int i = 0; i < n; ++i)
	            ess[i] = new int[] {efficiency[i], speed[i]};
	        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
	        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
	        long res = 0, sumS = 0;
	        for (int[] es : ess) {
	            pq.add(es[1]);
	            sumS = (sumS + es[1]);
	            if (pq.size() > k) sumS -= pq.poll();
	            res = Math.max(res, (sumS * es[0]));
	        }
	        return (int) (res % (long)(1e9 + 7));
	 }
}
