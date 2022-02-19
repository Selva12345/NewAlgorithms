package com.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperators {
	public static void main(String[] args) {
		ExpressionAddOperators e = new ExpressionAddOperators();
		System.out.println(e.addOperators("2147483648", -2147483648));
	}

	List<String> res;

	public List<String> addOperators(String num, int target) {
		int n = num.length();
		res = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		st.push(0);
		justDotIt(num, target, n, 0, st, new StringBuffer(), "+-*", false);

		return res;
	}

	private void justDotIt(String num, int target, int n, int s, Stack<Integer> st, StringBuffer sb, String symbol,
			boolean flag) {
		
		if (s == n) {
		
			long total = evaluate(sb);
			System.out.println(sb);
			if (total == target) {
				res.add(sb.toString());
			}
			return;
		}

		if (flag) {
			for (int i = 0; i < symbol.length(); i++) {
				sb.append(symbol.charAt(i));
				justDotIt(num, target, n, s, st, sb, symbol, false);
				sb.deleteCharAt(sb.length()-1);
			}
		} else if (!flag) {
			for(int i=s;i<num.length();i++) {
				String p=num.substring(s,i+1);
				if(p.length()>1&&p.charAt(0)=='0') {
					break;
				}
				sb.append(p);
				justDotIt(num, target, n, i + 1, st, sb, symbol, true);
				int d=(i+1)-s;
				sb.delete(sb.length()-d,sb.length());
			
			}
				
		}

	}

	private long evaluate(StringBuffer st) {
		long r = 0;
		StringBuffer sb = new StringBuffer(st);
		sb.append('+');
		Stack<Long> number = new Stack<>();
		long total = 0;
		char prev = '+';
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= '0' && c <= '9') {
				total = total * 10 + c - '0';
				continue;
			}

			if (prev == '+') {
				number.add(total);
			} else if (prev == '-') {
				number.add(-total);
			} else if (prev == '*') {
				long a = number.pop();
				number.add(a * total);
			}
			prev = c;
			total = 0;
		}
		while (!number.isEmpty()) {
			r += number.pop();
		}
		return r;
	}
}
