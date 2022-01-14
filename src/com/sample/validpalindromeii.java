package com.sample;

public class validpalindromeii {
	public static void main(String[] args) {
		validpalindromeii v=new validpalindromeii();
		v.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
	}

	public boolean validPalindrome(String s) {
		int i = 0, j = s.length() - 1, count = 0;
		while (i < j) {
			 System.out.println(s.charAt(i)+" "+s.charAt(j));
			if (s.charAt(i) != s.charAt(j)) {
				count++;
				if (count > 1)
					return false;
				if (s.charAt(i + 1) == s.charAt(j)) {
					i++;
				} else if (s.charAt(i) == s.charAt(j - 1)) {
					j--;
				}
			} else if (count <= 1) {
				i++;
				j--;
			}
		}
		return true;
	}
}
