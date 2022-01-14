package com.sample;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
	public static void main(String[] args) {
		AllPossibleFullBinaryTrees a=new AllPossibleFullBinaryTrees();
		a.allPossibleFBT(7);
	}

	public List<TreeNode> allPossibleFBT(int n) {
		List<TreeNode> ans = justDoIt(1, n);
		return ans;
	}

	private List<TreeNode> justDoIt(int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			List<TreeNode> r = new ArrayList<>();
			r.add(new TreeNode(0));
			return r;
		}
		List<TreeNode> res = new ArrayList<>();
		for (int i = start + 1; i <=end; i += 2) {
			List<TreeNode> left = justDoIt(start, i - 1);
			List<TreeNode> right = justDoIt(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode m = new TreeNode(0);
					m.left = l;
					m.right = r;
					res.add(m);
				}
			}
		}
		return res;
	}
}
