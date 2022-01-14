package com.uber;

import java.util.TreeMap;

public class NumberOfTrips {
	public static void main(String[] args) {
		NumberOfTrips num = new NumberOfTrips();
		int trips[][] = { { 0, 5 }, { 1, 2 }, { 3, 7 } };
		num.frequencyOfTrips(trips, new int[] { 0, 1 });
		num.frequencyOfTrips(trips, new int[] { 1, 2 });
		num.frequencyOfTrips(trips, new int[] { 2, 3 });
		num.frequencyOfTrips(trips, new int[] { 3, 5 });
		num.frequencyOfTrips(trips, new int[] { 5, 7 });
	}

	public int frequencyOfTrips(int[][] trips, int[] check) {
			TreeMap<Integer,Integer> freq=new TreeMap<>();
			for(int num[]:trips) {
				freq.put(num[0], num[1]);
			}
		return 0;

	}
}
