package com.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		LongestConsecutiveSequence c = new LongestConsecutiveSequence();
		System.out.println(c.longestConsecutive(new int[] {9,1,-3,2,4,8,3,-1,6,-2,-4,7}));
	}

	Map<Integer, Integer> mp;

	public int longestConsecutive(int[] nums) {
		mp = new HashMap<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			mp.putIfAbsent(nums[i], i);
		}
		Set<Integer> st = new HashSet<>();
		int parents[] = new int[n];
		Arrays.fill(parents, -1);
		for (int i = 0; i < n; i++) {
			int p = nums[i];
			if (mp.containsKey(p + 1) && !st.contains(p)) {
				unionFind(i, mp.get(p + 1), parents);
				st.add(p);
			}
		}
		int max = 0;
		for (int a : parents) {
			if(a<0)
			max = Math.max(Math.abs(a), max);
		}
		return max;
	}

	public void unionFind(int i, int j, int parents[]) {

		
		int a = find(i, parents);
		int b = find(j, parents);

		if (a != b) {
			union(a, b, parents);
		}

	}

	public void union(int a, int b, int[] parents) {

		if (a > b) {
			int temp=parents[a];
			parents[a] = b;
			parents[b] += temp;
		} else {
			int temp=parents[b];
			parents[b] = a;
			parents[a] += temp;
		}
	}

	public int find(int i, int parents[]) {

		if (parents[i] < 0) {
			return i;
		}
		return find(parents[i], parents);
	}
}
