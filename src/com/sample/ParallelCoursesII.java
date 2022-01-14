package com.sample;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ParallelCoursesII {
	public static void main(String[] args) {
		ParallelCoursesII p=new ParallelCoursesII();
		int a[][]= {{2,1},{3,1},{4,1},{1,5}};
		System.out.println(p.minNumberOfSemesters(5,a,2));
	}

	public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
		int[] prerequisites = new int[n]; // This array contains all the courses required by a destination course.
		 Deque<Integer> dq=new ArrayDeque<>();
		int[] dp = new int[1 << n];
		Arrays.fill(dp, -1);
		for(int i = 0; i < dependencies.length; i++){
			int source = dependencies[i][0];
			int dest = dependencies[i][1];
			prerequisites[dest - 1] ^= (1 << (source - 1));
		}
		return calculate(prerequisites, dp, k, n, 0);
	}

	private int calculate(int[] prerequisites, int[] dp, int k, int n, int available) {
		if(available == ((1 << n) - 1)) return 0;
		if(dp[available] != -1) return dp[available];

		int ans = Integer.MAX_VALUE;

		for(int i = 0; i < n; i++){
			int current = available;
			int counter = 0;
			int j = i; 
			while (counter < k && j < n) { // Take atmost k courses from the current index i. 
				if ((available & (1 << j)) == 0 && ((prerequisites[j] & available) == prerequisites[j])) { // If the course is not taken yet and all its prerequisites have been taken.
					current ^= (1 << j);
					counter++;
				}
				j++;	
			}
			if(current != available){ // If current is equal to available couldn't find any courses this semester
				int val = calculate(prerequisites, dp, k, n, current);
				if (val != Integer.MAX_VALUE)
					ans = Math.min(ans, 1 + val);
			}
		}
		dp[available] = ans;
		return ans;
	}
}
