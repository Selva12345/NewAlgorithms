package com.sample;

public class WordDictionary {
	public static void main(String[] args) {
		WordDictionary w=new WordDictionary();
		w.addWord("a");
		w.addWord("a");
		w.search(".");
		w.search("a");
		w.search("aa");
		w.search("a");
		w.search(".a");
		w.search("a.");
	}

	WordDictionary dict[];
	boolean isEnd = false;

	public WordDictionary() {
		dict = new WordDictionary[26];
		for (int i = 0; i < 26; i++) {
			dict[i] = null;
		}
	}

	public void addWord(String word) {
		WordDictionary temp[] = dict;
		int n = word.length();
		for (int i = 0; i < n; i++) {
			char c = word.charAt(i);
			if (temp[c - 'a'] == null) {
				temp[c - 'a'] = new WordDictionary();
			}
			WordDictionary w = temp[c - 'a'];
			temp = w.dict;
			if (i == n - 1) {
				w.isEnd = true;
			}
		}
	}

	public boolean search(String word) {
		WordDictionary temp[] = dict;
		int n = word.length();
		return finder(word, 0, temp, n);
	}

	private boolean finder(String word, int s, WordDictionary temp[], int n) {
		char c = word.charAt(s);
		if (c != '.') {
			if (temp[c - 'a'] != null) {
				WordDictionary w = temp[c - 'a'];
				if (w.isEnd == true)
					return true;
				if (finder(word, s + 1, w.dict, n))
					return true;
			}
		} else {
			for (int i = 0; i < 26; i++) {
				if (temp[i] != null) {
					WordDictionary w = temp[i];
					if (w.isEnd == true&&s==n-1)
						return true;
					if (finder(word, s + 1, w.dict, n))
						return true;
				}
			}
		}
		return false;
	}
}
