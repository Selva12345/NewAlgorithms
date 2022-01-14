package com.sample;

public class SwapAdjacentInLRString {
	public static void main(String[] args) {
		SwapAdjacentInLRString s=new SwapAdjacentInLRString();
		//"XXXLLR"
		//"LLXXXR"
		System.out.println(s.canTransform("RXR", "XXR"));
	}

	 public boolean canTransform(String start, String end) {
			if (start.length() != end.length()) {
				return false;
			}

			int i = 0, j = 0, n = start.length();
			char S[] = start.toCharArray();
			char E[] = end.toCharArray();
			if (n == 1)
				return false;
			while (i < n) {
				if (S[i] == E[j]) {
					i++;
					j++;
					continue;
				}else if(S[i] == 'R' && E[j] == 'X') {
					while (i < n && S[i] != E[j] && S[i] == 'R' && E[j] == 'X') {
						if(i+1>=n)return false;
	                    int t=i+1;
	                    while(t<n&&S[t] == 'R')t++;
						if (t<n&&S[t] == 'X') {
							char temp=S[t];
							S[t]=S[i];
							S[i]=temp;
						} else {
							return false;
						}
						i++;
	                    j++;
					}
				}else if(S[i] == 'X' && E[j] == 'L') {
					while (i < n && S[i] != E[j] && S[i] == 'X' && E[j] == 'L') {
						if(i+1>=n)return false;
	                      int t=i+1;
	                    while(t<n&&S[t] == 'X')t++;
						if (t<n&&S[t] == 'L') {
							char temp=S[t];
							S[t]=S[i];
							S[i]=temp;
						} else {
							return false;
						}
						i++;
	                    j++;
					}
				}else if(S[i] != E[j]){
					return false;
				}else if(new String(S).equals(new String(E))){
	                return true;
	            }
			}
			return true;
		}
}
