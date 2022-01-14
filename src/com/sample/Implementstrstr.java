package com.sample;

public class Implementstrstr {
	public static void main(String[] args) {
		Implementstrstr i=new Implementstrstr();
		System.out.println(i.strStr("aaaaadad", "aaad"));
	}

	public int strStr(String haystack, String needle) {
		int n = haystack.length();
		int m = needle.length();
		if (needle.equals("")) {
			return 0;
		}
		int lps[] = new int[m];
		pattern(lps, m, needle.toCharArray());
		return find(lps, haystack.toCharArray(), needle.toCharArray(), n,m);
	}

	private int find(int lps[], char arr[], char val[], int n,int m) {
		int i = 0;
		int j = 0;
		
		while(j<n) {
			if(val[i]==arr[j]) {
				i++;
				j++;
			}else {
				if(i>0){
					i=lps[i-1];
				}else {
					j++;
				}
				
			}
			
			if(i==m) {
				return j-i+1;
			}
		}
	return -1;
	}

	private void pattern(int lps[], int m, char arr[]) {
		int i=1;
		
		int c=0;
		while (i < m) {
			if(arr[i]==arr[c]) {
				lps[i]=++c;
				i++;
			}else {
				if(c>0) {
					c=lps[c-1];
				}else {
					lps[c]=0;
					i++;
				}
					
			}
			
		}
	}
}
