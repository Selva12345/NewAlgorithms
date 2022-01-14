package com.sample;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestAbsoluteFilePath {
	public static void main(String[] args) {
		LongestAbsoluteFilePath v = new LongestAbsoluteFilePath();
		System.out.println(v.lengthLongestPath("a\n\taa\n\t\taaa\n\t\t\tfile1234567890123.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
	}

	public int lengthLongestPath(String input) {
		String sp[] = input.split("\n");
		int n = sp.length;
		String prev = "";
		return solver(sp, n);
	}

	private int solver(String sp[], int n) {
		String prev = "";
		int ans = 0,max=0;
		Map<Integer, String> mp = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String cur = sp[i];
			int a = isValid(prev);
			int b = isValid(cur);
			max=Math.max(b,max);
			if (a < b) {
				mp.put(b, cur);
				prev = cur;
			} else {
				max+=1;
				for(;;max++) {
					if(mp.get(max)!=null) {
						mp.remove(max);
					}else {
						break;
					}
				}
				
				ans = Math.max(ans, evaluate(mp));
				i--;
				prev = "";
				max=0;
			}

		}
		max+=1;
		for(;;max++) {
			if(mp.get(max)!=null) {
				mp.remove(max);
			}else {
				break;
			}
		}
		ans = Math.max(ans, evaluate(mp));
		return ans;
	}

	private int isValid(String cur) {
		if (cur.equals(""))
			return -1;
		int c = 0;
		for (int j = 0; j < cur.length(); j++) {
			char a = cur.charAt(j);
			if (cur.charAt(j) == '\t') {
				c++;
			} else {
				break;
			}
		}

		return c;
	}

	private int evaluate(Map<Integer, String> mp) {
		StringBuilder sb = new StringBuilder();
		String s = "";
		for (int k : mp.keySet()) {
			s = mp.get(k);
			StringBuilder temp = new StringBuilder();
			for (char c : s.toCharArray()) {
				if (c != '\t')
					temp.append(c + "");
			}
			sb.append(temp + "/");
		}
		if (isFile(s)) {
			return sb.length() - 1;
		}
		return 0;
	}
	private boolean isFile(String f) {
		for (int i = 0; i < f.length(); i++) {
			if (f.charAt(i) == '.') {
				return true;
			}
		}
		return false;
	}
}
