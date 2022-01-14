package com.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RectangleAreaIITry {
	public static void main(String[] args) {
		int[][] mat = { { 0, 0, 3, 3 }, {2,2,5,5},{1,1,4,4} };
		RectangleAreaIITry r = new RectangleAreaIITry();
		System.out.println(r.rectangleArea(mat));
	}

	public int rectangleArea(int[][] rectangles) {
		int N = rectangles.length;
		Set<Integer> xSet = new HashSet<>();
		Set<Integer> ySet = new HashSet<>();
		for (int[] rec : rectangles) {
			xSet.add(rec[0]);
			xSet.add(rec[2]);
			ySet.add(rec[1]);
			ySet.add(rec[3]);
		}
		Integer[] xArr = xSet.toArray(new Integer[0]);
		Integer[] yArr = ySet.toArray(new Integer[0]);
		Arrays.sort(xArr);
		Arrays.sort(yArr);
		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();
		for (int i = 0; i < xArr.length; i++) {
			xMap.put(xArr[i], i);
		}
		for (int i = 0; i < yArr.length; i++) {
			yMap.put(yArr[i], i);
		}
		boolean[][] grid = new boolean[xArr.length][yArr.length];
		for (int[] rec : rectangles) {
			for (int x = xMap.get(rec[0]); x < xMap.get(rec[2]); x++) {
				for (int y = yMap.get(rec[1]); y < yMap.get(rec[3]); y++) {
					grid[x][y] = true;
				}
			}
		}
		long res = 0L;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j]) {
					res += (long) (xArr[i + 1] - xArr[i]) * (yArr[j + 1] - yArr[j]);
				}
			}
		}
		res %= 1000_000_007;
		return (int) res;
	}
}
