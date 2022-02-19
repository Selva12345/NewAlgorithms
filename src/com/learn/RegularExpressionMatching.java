package com.learn;

public class RegularExpressionMatching {
	public static void main(String[] args) {
		RegularExpressionMatching r=new RegularExpressionMatching();
		//"mississippi"
		//"mis*is*p*."
		System.out.println(r.isMatch("mississippi","mis*is*p*."));
	}

	public boolean isMatch(String s, String p) {
		boolean res = justDoIt(s, p, '0', 0, 0);
		return res;
	}

	private boolean justDoIt(String s, String p, char prev, int i, int j) {
		if (i >= s.length()&&(j>=p.length()||p.charAt(p.length()-1)=='*')) {
			return true;
		}
		
		for (int x = i,y=j; x <s.length()&& y < p.length(); x++,y++) {
			
				System.out.println(s.charAt(x) + " " + p.charAt(y));
				if (s.charAt(x) == p.charAt(y) || p.charAt(y) == '.') {
					if (justDoIt(s, p, p.charAt(y), x+ 1, y + 1))
						return true;
				} else if (p.charAt(y) == '*' && (prev == s.charAt(x) || prev == '.')) {
					if (justDoIt(s, p, prev, x + 1, y))
						return true;
				}else if ((y + 1 < p.length()) && p.charAt(y + 1) == '*') {
                    if (justDoIt(s, p,p.charAt(y+1), x, y + 2))
                        return true;
                }

		}

		return false;
	}
}
