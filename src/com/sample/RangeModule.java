package com.sample;

import java.util.SortedMap;
import java.util.TreeMap;

public class RangeModule {
	public static void main(String[] args) {
		RangeModule r=new RangeModule();

			r.addRange(6,8);
			r.removeRange(7,8);
			r.removeRange(8,9);
			r.addRange(8,9);
			r.removeRange(1,3);
			r.addRange(1,8);
			r.queryRange(2,4);
			r.queryRange(2,9);
			r.queryRange(4,6);
	}

	TreeMap<Integer, Integer> range;

	public RangeModule() {
		range = new TreeMap<>();
	}

	public void addRange(int left, int right) {
		if (!range.isEmpty()) {
			Integer f = range.floorKey(left);
			Integer nxt = 0;
			if (f != null)
				nxt = range.get(f);
			if (nxt > left)
				left = f;
			SortedMap<Integer, Integer> tr = range.subMap(left, right+1);
			if (tr.isEmpty()) {
				range.put(left, right);
				return;
			}
			int val = tr.get(tr.lastKey());
			if (val > right) {
				right = val;
			}
			tr.clear();
		}
		range.put(left, right);
		System.out.println(range);

	}

	public boolean queryRange(int left, int right) {
		if (!range.isEmpty()) {
			Integer f = range.floorKey(left);
			Integer nxt = 0;
			if (f != null)
				nxt = range.get(f);
			if (left >=f) {
				if (right <= nxt) {
					return true;
				}
			}

		}
		return false;
	}

	public void removeRange(int left, int right) {
		if (!range.isEmpty()) {
			Integer f = range.floorKey(left);
			Integer nxt = null;
			if (f != null)
				nxt = range.get(f);
			System.out.println(f + " " + nxt);
			if (nxt!=null&&nxt > left)
				range.put(f, left);
			System.out.println(range);
			SortedMap<Integer, Integer> tr = range.subMap(left, right);

			if (tr.isEmpty()) {
				if(nxt!=null)
				range.put(right, nxt);
				return;
			}
			int k = tr.lastKey();
			int val = tr.get(k);
			if (val > right) {
				range.put(right, val);
			}
			tr.clear();

		}

	}
}
