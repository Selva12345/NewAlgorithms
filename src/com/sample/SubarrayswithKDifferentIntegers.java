package com.sample;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SubarrayswithKDifferentIntegers {
	public static void main(String[] args) {
		SubarrayswithKDifferentIntegers s=new SubarrayswithKDifferentIntegers();
		int nums[]= {2,2,1,2,2,2,1,1};
		System.out.println(s.subarraysWithKDistinct(nums, 2));
	}

	public int subarraysWithKDistinct(int[] nums, int k) {
		Map<Integer, Integer> mp = new HashMap<>();
		int n = nums.length;
		Deque<Integer> dq = new ArrayDeque<>();
		int j = 0, count = 0;
		for (int i = 0; i < n; i++) {
			if (mp.size() == k && !mp.containsKey(nums[i])) {
				j=0;
				while (dq.size() >= k && mp.size() == k) {
					int index = dq.pollFirst();
					if (mp.get(nums[index]) > 1) {
						mp.put(nums[index], mp.getOrDefault(nums[index], 0) - 1);
					} else if (mp.get(nums[index]) == 1) {
						mp.remove(nums[index]);
					}
					
					if (mp.size() == k) {
						count += 1;
						count += j++;
					}

				}
			}
			// System.out.println(mp+" "+c);
			mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
			if (mp.size() == k)
				count += 1;

			dq.offer(i);
		}
		if (mp.size() >= k) {
			j=0;
			while (dq.size() > k && mp.size() == k) {
				int index = dq.pollFirst();
				if (mp.get(nums[index]) > 1) {
					mp.put(nums[index], mp.getOrDefault(nums[index], 0) - 1);
				} else if (mp.get(nums[index]) == 1) {
					mp.remove(nums[index]);
				}
				if (mp.size() == k) {
					count += 1;
					count += j++;
				}
			}
		}
		return count;
	}
}
