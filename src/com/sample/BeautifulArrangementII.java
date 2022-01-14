package com.sample;

public class BeautifulArrangementII {
	public static void main(String[] args) {
		BeautifulArrangementII b=new BeautifulArrangementII();
		b.constructArray(5, 4);
	}

	public int[] constructArray(int n, int k) {
		int ans[] = new int[n];
		int val = 1;
		int r = k;
		boolean flag = false;
		ans[0]=1;
		int i = 1;
		while (k > 0) {
			if (k > 0) {
				if (!flag) {
					flag = true;
					val += k;
					ans[i] = val;

				} else {
					flag = false;
					val -= k;
					ans[i] = val;
				}
				k--;
			}
			i++;
		}
		val = val + 1;
		while (i < n) {
			ans[i] = val;
			val++;
			i++;
		}
		return ans;
	}
}
