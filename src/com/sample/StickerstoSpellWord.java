package com.sample;

public class StickerstoSpellWord {
	public static void main(String[] args) {
		StickerstoSpellWord s=new StickerstoSpellWord();
		System.out.println(s.minStickers(new String[] {"with","example","science"},"thehat"));
	}

	int min =Integer.MAX_VALUE;

	public int minStickers(String[] stickers, String target) {
		int n = stickers.length;
		int[] tar = new int[26];
		for (char a : target.toCharArray())
			tar[a - 'a']++;
		justDoIt(tar, stickers, 0, 0);
		return min==Integer.MAX_VALUE?-1:min;
	}

	private void justDoIt(int target[], String[] stickers, int s, int c) {
		if (check(target)) {
			min = Math.min(c, min);
			return;
		}

		for (int i = 0; i < stickers.length; i++) {
			String str = stickers[i];
			boolean flag = false;
			StringBuilder sb = new StringBuilder();
			for (char a : str.toCharArray()) {
				if (target[a - 'a'] > 0) {
					target[a - 'a']--;
					sb.append(a + "");
					flag = true;
				}
			}
			if (flag) {
				justDoIt(target, stickers, s, c + 1);
				for (int j = 0; j < sb.length(); j++) {
					char a = sb.charAt(j);
					target[a - 'a']++;
				}

			}
		}
	}

	private boolean check(int target[]) {
		for (int a : target) {
			if (a > 0)
				return false;
		}
		return true;
	}
}
