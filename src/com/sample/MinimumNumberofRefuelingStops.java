package com.sample;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {
	public static void main(String[] args) {
		MinimumNumberofRefuelingStops m=new MinimumNumberofRefuelingStops();
		int mat[][]={{98,5},{243,71},{320,137},{353,88},{427,153},{574,194},{686,134},{732,134},{818,29},{949,118}};
		System.out.println(m.minRefuelStops(1000, 299,mat));
		
		}
		 public int minRefuelStops(int target, int startFuel, int[][] stations) {
				int n = stations.length;
				Arrays.sort(stations, (a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
				PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
	
				int i = 0, c = 0;
	
				if (startFuel >= target)
					return c;
	
				while (i < n) {
					pq.offer(stations[i]);
					i++;
					int max=0;
					PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
					while (!pq.isEmpty() && pq.peek()[0] <= startFuel) {
					//	System.out.println(" miles " + pq.peek()[0]+" Fuel "+max);
						q.offer(pq.poll());
					}
					if(!q.isEmpty()) {
						 max=q.poll()[1];
						 
					}
					if(!q.isEmpty()) {
						pq.addAll(q);
						 
					}
					
					if(max>0) {
						startFuel += max;
						
						//System.out.println("total fuel " + startFuel);
						c++;
						if (startFuel >= target)
							return c;
							
					}
					
				}
				

				while (!pq.isEmpty()) {
					
					int max=0;
					PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
					while (!pq.isEmpty() && pq.peek()[0] <= startFuel) {
					//	System.out.println(" miles " + pq.peek()[0]+" Fuel "+max);
						q.offer(pq.poll());
					}
					if(!q.isEmpty()) {
						 max=q.poll()[1];
						 
					}
					if(!q.isEmpty()) {
						pq.addAll(q);
						 
					}
					
					if(max>0) {
						startFuel += max;
						
						//System.out.println("total fuel " + startFuel);
						c++;
						if (startFuel >= target)
							return c;
							
					}else {
						break;
					}
					
				}
				return -1;
			}
	 
}