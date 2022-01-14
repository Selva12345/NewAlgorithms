package com.sample;

import java.util.Stack;

public class BasicCalculatorII {
	public static void main(String[] args) {
		BasicCalculatorII b = new BasicCalculatorII();
		b.calculate("12-3*4");
	}

	public int calculate(String s) {
		 s=s+"+";
		 
		int n = s.length();
		char prev = '+';
		int cur = 1;
		int slow = 0, sum = 0, nxt = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n;) {
			char c = s.charAt(i);
			if(c==' ') {
				i++;
				continue;
			}
			if (c >= '0' && c <= '9') {
				nxt = nxt * 10;
				nxt += (c - '0');
				i++;
				continue;
			}
			if (prev == '+') {
				st.push(nxt);
				cur = 1;
			} else if (prev == '-') {
				cur = -1;
				st.push(nxt*cur);
				
			} else if (prev == '*') {
				slow = st.pop();
				nxt = nxt * slow ;
				st.push(nxt);
			} else if (prev == '/') {
				slow = st.pop();
				nxt = (slow / nxt) ;
				st.push(nxt);
			}
			prev = c;

			nxt = 0;
			i++;
		}

		int f = 0;
		for (int d : st) {
			f += d;
		}
		return f;
	}
}
