package com.sample;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
	public static void main(String[] args) {
		DifferentWaystoAddParentheses d = new DifferentWaystoAddParentheses();
		System.out.println(d.diffWaysToCompute("2*3-456*5"));
	}

	public List<Integer> diffWaysToCompute(String expression) {
		int n = expression.length();
		return justDoIt(expression, 0, n);
	}

	private List<Integer> justDoIt(String express, int s, int n) {
		
			String st=express.substring(s,n);
			boolean f=false;
			for(char c:st.toCharArray()) {
				if(!Character.isDigit(c)) {
					f=true;
					break;
				}
			}
			if(!f&&!st.isEmpty()) {
				int v = Integer.parseInt(st);
				List<Integer> temp=new ArrayList<>();
				temp.add(v);
				return temp ;
			}
			
		List<Integer> t = new ArrayList<>();
		for (int i = s + 1; i < n; i++) {
			List<Integer> t1=null,t2=null;
			if(express.charAt(i)=='*'||express.charAt(i)=='+'||express.charAt(i)=='-') {
				 t1= justDoIt(express, s, i);
				 t2 = justDoIt(express, i + 1, n);
			}
			

			if (express.charAt(i) == '*') {
				for (int a : t1) {
					for (int b : t2) {
						t.add(a * b);
					}
				}
			} else if (express.charAt(i) == '+') {
				for (int a : t1) {
					for (int b : t2) {
						t.add(a + b);
					}
				}
			} else if (express.charAt(i) == '-') {
				for (int a : t1) {
					for (int b : t2) {
						t.add(a - b);
					}
				}
			}

		}

		return t;
	}

}
