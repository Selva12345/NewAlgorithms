package com.sample;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
	public static void main(String[] args) {
		MinimumCosttoHireKWorkers m = new MinimumCosttoHireKWorkers();
		int q[] = { 3, 6, 5, 5, 3, 8 };
		int w[] = { 5, 1, 4, 4, 1, 3 };
		int k = 4;
		System.out.println(m.mincostToHireWorkers(q, w, k));
	}

	public double mincostToHireWorkers(int[] q, int[] w, int K) {
		double[][] workers = new double[q.length][2];
		for (int i = 0; i < q.length; ++i)
			workers[i] = new double[] { (double) (w[i]) / q[i], (double) q[i] };
		Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
		double res = Double.MAX_VALUE, qsum = 0;
		PriorityQueue<Double> pq = new PriorityQueue<>();
		for (double[] worker : workers) {
			qsum += worker[1];
			pq.add(-worker[1]);
			if (pq.size() > K)
				qsum += pq.poll();
			if (pq.size() == K)
				res = Math.min(res, qsum * worker[0]);
		}
		return res;
	}
}
