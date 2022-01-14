package com.sample;

import java.util.LinkedList;
import java.util.Queue;

public class MagicalString {
	public static void main(String[] args) {
		MagicalString m=new MagicalString();
		System.out.println(m.magicalString(1000));
	}

	public int magicalString(int n) {
		if (n == 1)
			return 1;
		Queue<Integer> q = new LinkedList<>();
		q.offer(2);
		StringBuilder sb = new StringBuilder();
		sb.append("122");
		int count = 1, total = 3, prev = 2;
		while (!q.isEmpty()) {
			int value = q.poll();
			if (prev ==1) {
				while (value > 0) {
					q.offer(2);
					value--;
					total++;
					if (n == total)return count;

				}
				prev = 2;

			} else if (prev == 2) {
				while (value > 0) {
					count++;
					q.offer(1);
					value--;
					total++;
					if (n == total)return count;

				}
				prev = 1;
			}
			if(900<total)
				System.out.println("Here");
			
			
		}
		if (n == total)
			return count;
		return -1;
	}

}
