package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		// "wordgoodgoodgoodbestword"
		// ["word","good","best","good"]
		// "aaaaaaaaaaaaaa"
		// ["aa","aa"]
		// "barfoofoobarthefoobarman"
		// ["bar","foo","the"]
		System.out.println(s.findSubstring("aaaaaaaaaaaa", new String[] { "aa", "aa" }));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		Map<String, Integer> mp = new HashMap<>();
		int n = words.length;
		int k = words[0].length();
		int total = k * n;
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			mp.put(words[i], mp.getOrDefault(words[i], 0) + 1);
		}
		int m = s.length();
		int i = 0, j = 0;
		while (i < m - k) {
			Map<String, Integer> seen = new HashMap<>();
			String str = s.substring(i, i + k);
			if (!mp.containsKey(str)) {
				i++;
				continue;
			}
			i = i + k;
			while (i < m - k && mp.get(str) >= mp.getOrDefault(str, 0) + 1) {
				seen.put(str, mp.getOrDefault(str, 0) + 1);
				str = s.substring(i, i + k);
				i += k;
			}
			i -= k;
			if (i - j == total) {
				ans.add(j);
			}

			j = i;
			i++;
		}
		return ans;
	}
}
