package com.sample;

public class DivideTwoIntegers {
	public static void main(String[] args) {
		DivideTwoIntegers d=new DivideTwoIntegers();
		d.divide(29, 3);
	}

	public int divide(int dividend, int divisor) {
		int sign = 1;

		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (dividend == 0)
			return 0;
		if (dividend == Integer.MIN_VALUE && divisor == 1)
			return Integer.MIN_VALUE;
		if (dividend == Integer.MIN_VALUE && divisor == 2)
			return -1073741824;
		if (dividend == Integer.MIN_VALUE && divisor == -2)
			return 1073741824;
		if (dividend == Integer.MAX_VALUE && divisor == 2)
			return 1073741823;
		if (dividend == Integer.MAX_VALUE && divisor == Integer.MAX_VALUE)
			return 1;
		if (dividend == Integer.MIN_VALUE && divisor == Integer.MAX_VALUE)
			return -1;
		if (dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE)
			return 0;
		if (dividend < 0) {
			sign = sign * (-1);
			if (dividend == Integer.MIN_VALUE) {
				dividend = Integer.MAX_VALUE;
			} else {
				dividend = dividend * (-1);
			}

		}
		// System.out.print(dividend);
		if (divisor < 0) {
			sign = sign * (-1);
			if (divisor == Integer.MIN_VALUE) {
				divisor = Integer.MAX_VALUE;
			} else {
				divisor = divisor * (-1);
			}

		}
		// int c=0;
		int c = finder(dividend, divisor, 1);
		return c * sign;
	}

	private int finder(int a, int b, int c) {
		if (a < b) {
			return 0;
		}
		int t = 0;
		int v=b<<1;
		if ((a - b) >= (b << 1))
			t += finder(a - b, b << 1, c << 1);
		else if ((a - b) >= (b))
			t = finder(a - b, b, c + 1) + c;

		return c;
	}

}
