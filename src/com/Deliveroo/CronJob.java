package com.Deliveroo;

import java.util.ArrayList;
import java.util.List;

public class CronJob {
	public static void main(String[] args) {
		String expression = "10/15 0 1,4-15 * 1-5 /usr/bin/find";
		CronJob cronJob = new CronJob();
		cronJob.parser(expression);
	}

	private void parser(String expression) {
		String[] parts = expression.split(" ");
		for (int i = 0; i < parts.length - 1; i++) {
			String subParts[]=parts[i].split(",");
		
			List<Integer> cur=new ArrayList<>();
			for(String s:subParts) {
				
				cur.addAll(getValue(s,i));
			}
		
			
			System.out.println(cur);
		}
		System.out.println(parts[parts.length - 1]);
	}

	private List<Integer> getValue(String str, int pos) {
		char[] arr = str.toCharArray();
		int total = 0;
		boolean flag = false;
		List<Integer> out = new ArrayList<>();
		if (str.contains("*/")) {
			solver(str, pos, out);
		} else if (str.contains("/")) {
			solver(str, pos, out);
		} else if (str.contains(",")) {
			String s[] = str.split(",");
			solverCommaValues(s, out);
		} else if (str.contains("-")) {
			String s[] = str.split("-");
			solverHyphenValues(s, out);
		} else if (str.contains("*")) {
			if(str.length()>1)throw new IllegalArgumentException(str);
			solverAstrikValues(getMax(pos), getMin(pos), out);
		}else {
			out.add(Integer.parseInt(str));
		}
		return out;
	}

	private int getMin(int pos) {
		if (pos == 0) {
			return 0;
		} else if (pos == 1) {
			return 0;
		} else if (pos == 2) {
			return 1;
		} else if (pos == 3) {
			return 1;
		} else {
			return 1;
		}

	}

	private void solverAstrikValues(int max, int min, List<Integer> out) {
		for (int i = min; i <= max; i++)
			out.add(i);
	}

	private void solverHyphenValues(String[] s, List<Integer> out) {
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);
		for (int i = start; i <= end; i++) {
			out.add(i);
		}
	}

	private void solverCommaValues(String[] s, List<Integer> out) {
		for (String c : s) {
			out.add(Integer.parseInt(c));
		}
	}

	private void solver(String s, int pos,List<Integer> out) {
		String parts[]=s.split("/");
		if(parts.length>2) {
			throw new IllegalArgumentException();
		}
		int inc=0,start=0;
		if(parts.length==2)
		 inc=Integer.parseInt(parts[1]);
		if(parts[0].equals("*")) {
			start=Integer.parseInt(parts[0]);
		}
		
		for(int i=0;i<=getMax(pos);i+=inc) {
			out.add(i);
		}
	}

	private int getMax(int pos) {
		if (pos == 0) {
			return 60;
		} else if (pos == 1) {
			return 24;
		} else if (pos == 2) {
			return 30;
		} else if (pos == 3) {
			return 12;
		} else {
			return 7;
		}
	}

}
