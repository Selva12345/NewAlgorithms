package com.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SplitArrayIntoConsecutiveSubsequences {
	public static void main(String[] args) {
		SplitArrayIntoConsecutiveSubsequences s = new SplitArrayIntoConsecutiveSubsequences();
		System.out.println(s.isPossible(new int[] {1,2,3,4,5,5,6,7}));
	}// 1 2 3 3 4 5

	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> mp = new HashMap<>();
		int n = nums.length;
		if (n < 3)
			return false;
		for (int i = 0; i < n; i++) {
			mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
		}
		for (int i = 0; i < n; i++) {
			int cur = nums[i];
			if (mp.get(cur) <= 0)
				continue;

			if (mp.getOrDefault(cur,0) <= mp.getOrDefault(cur + 1,0) &&
					mp.getOrDefault(cur + 1,0) <= mp.getOrDefault(cur + 2,0)) {
				mp.put(cur, mp.get(cur) - 1);
				mp.put(cur+1, mp.get(cur + 1) - 1);
				int val = cur + 3;
				while (mp.getOrDefault(val,0) > 0 && mp.get(val - 1) <= mp.get(val)) {
					mp.put(val-1, mp.get(val-1) - 1);
					val++;
				}
				mp.put(val-1, mp.get(val-1) - 1);
				
			} else {
				return false;
			}

		}
		return true;

	}
}
