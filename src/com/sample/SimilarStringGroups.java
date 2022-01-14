package com.sample;

import java.util.Arrays;

public class SimilarStringGroups {
	public static void main(String[] args) {
		SimilarStringGroups s=new SimilarStringGroups();
		String strs[]= {"ajdidocuyh",
						"djdyaohuic",
						"ddjyhuicoa",
				"djdhaoyuic","ddjoiuycha","ddhoiuycja","ajdydocuih","ddjiouycha","ajdydohuic","ddjyouicha"};
		System.out.println(s.numSimilarGroups(strs));
	}

	public int numSimilarGroups(String[] strs) {
		int n = strs.length;

		int parent[] = new int[n];
		Arrays.fill(parent, -1);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				String p1 = strs[i];
				String p2 = strs[j];
				if ((parent[i] == -1 || parent[j] == -1) && find(p1, p2)) {
					union(i, j, parent);
				}
			}

		}
		int r = 0;
		for (int i = 0; i < n; i++) {
			if (parent[i] == -1) {
				r++;
			}
		}
		return r;
	}

	private boolean find(String s1, String s2) {
		int c = 0;
		for (int k = 0; k < s1.length(); k++) {
			if (s1.charAt(k) != s2.charAt(k)) {
				c++;
			}
		}
		return c <= 2;
	}

	private void union(int i, int j, int parent[]) {
		if (parent[i] == -1 && parent[j] != -1 && parent[j] < i) {
			parent[i] = parent[j];
		}
		
		
			parent[j] = i;
	}
}
