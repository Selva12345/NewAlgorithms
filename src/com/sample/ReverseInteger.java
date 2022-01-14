package com.sample;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		int v = -2147483412;
		int y=2143847412;
		List<Integer> arr=new ArrayList<>();
		arr.add(2);
		arr.remove(2);
		System.out.println(r.reverse(v));
	}

	public int reverse(int x) {
		// System.out.println(x);
		if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE)
			return 0;

		int neg = 1;
		if (x < 0) {
			x *= -1;
			neg = -1;
		}
		int total = 0;
		int temp = 0;
		int max = (1 << 31) - 1;
		while (x > 0) {
			int r = x % 10;
			x = x / 10;

			if (!check(total, max, r)) {
				return 0;
			}

			total = (total * 10) + r;
		}

		return total * neg;
	}

	private boolean check(int nxt, int max, int s) {
		int v = 0;
		int h=nxt;
		nxt=0;
		while (v < 10) {
			if (max - (nxt + h) < 0) {
				return false;
			}
			nxt =nxt+h;
			v++;
		}
		if (max - (nxt + s) < 0) {
			return false;
		}
		return true;
	}
}
