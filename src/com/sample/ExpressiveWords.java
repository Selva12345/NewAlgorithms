package com.sample;

public class ExpressiveWords {

	public static void main(String[] args) {
		ExpressiveWords e=new ExpressiveWords();
		e.expressiveWords("heeellooo", new String[] {"hello", "hi", "helo"});
	}

	public int expressiveWords(String s, String[] words) {
		int arr[] = new int[26];
		int n = words.length;
		int m = s.length();
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			String st = words[i];
			int j = 0, k = 0;
			boolean flag = false;
			while (j < m) {
				int c = 0, v = 0;
				char c1 = s.charAt(j);
				char c2 = st.charAt(k);
				while (j < m && c1 == s.charAt(j)) {
					c++;
					j++;
				}
				if (c1 != c2) {
					flag = true;
					break;
				}

				while (k < st.length() && c2 == st.charAt(k)) {
					v++;
					k++;
				}

				System.out.println(c + " " + c1 + " - " + v + " " + c2);

				if (c != v) {
					if (c < 3) {
						flag = true;
						break;
					}
				}

			}
			if (!flag) {
				res++;
			}
		}
		return res;
	}
}
