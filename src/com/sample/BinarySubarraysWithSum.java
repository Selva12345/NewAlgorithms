package com.sample;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySubarraysWithSum {
	public static void main(String[] args) {
		BinarySubarraysWithSum b = new BinarySubarraysWithSum();
		System.out.println(b.numSubarraysWithSum(new int[] { 1,0,1,1,1,0 }, 2));
	}

	public int numSubarraysWithSum(int[] nums, int goal) {
		int n = nums.length;
		int prefix[] = new int[n];
		prefix[0] = nums[0];
		for (int i = 1; i < n; i++)
			prefix[i] = prefix[i - 1] + nums[i];

		int count = 0, prev = 0, nxt = 0;
		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
		
			while (dq.size() > 0 && prefix[i] - prefix[dq.getFirst()] == goal) {
				nxt++;
				dq.pollFirst();
			}
			while (dq.size() > 0 && prefix[i] - prefix[dq.getFirst()] > goal) {
				dq.pollFirst();
			}
			if(i>0&&prefix[i]!=prefix[i-1]) {
				if(prefix[i]!=goal)nxt=0;
			}
			if (prefix[i] == goal) {
				count += nxt+1;

			} else {
				count += nxt;
			}

			dq.offer(i);
		}
		return count;
	}
}
