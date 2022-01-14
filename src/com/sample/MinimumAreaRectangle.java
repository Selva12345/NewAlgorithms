package com.sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class MinimumAreaRectangle {
	public static void main(String[] args) {
		MinimumAreaRectangle m=new MinimumAreaRectangle();
		int points[][]= {{3,2},{1,3},{3,0},{3,4},{2,1},{0,4},{0,3},{4,1},{2,4}};
		System.out.println(m.minAreaRect(points));
	}

	public int minAreaRect(int[][] points) {
		int n = points.length;
		int m = points.length;
		StringBuilder s=new StringBuilder();
	
		
		Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		TreeMap<Integer, Integer> tr = new TreeMap<>();
		Set<String> st = new HashSet<>();
		for (int i = 0; i < points.length; i++) {
			tr.putIfAbsent(points[i][0], i);
			st.add(points[i][0] + "-" + points[i][1]);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int a[] = points[i];
			int b[] = null;
			int c[] = null;
			int d[] = null;
			Integer q = tr.ceilingKey(a[0] + 1);
			if (q== null)
				continue;
			
			int p=tr.get(q);
			for (int j = p; j < n; j++) {
				//if(a[0]<points[j][0])break;
				
				if (a[1] != points[j][1]) {
					continue;
				}
				b = points[j];
				for (int k = j; k < n; k++) {
					if(b[0]<points[k][0])break;
					
					if (b[1] >= points[k][1]) {
						continue;
					}
					c = points[k];
					String key = a[0] + "-" + c[1];
					if (!st.contains(key)) {
						continue;
					}
					min = Math.min(min, (b[0] - a[0]) * (c[1] - b[1]));
				}

			}

		}
		return min;
	}
}
