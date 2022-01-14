package com.sample;

public class LowestCommonAncestor {
	public static void main(String[] args) {
		LowestCommonAncestor l=new LowestCommonAncestor();
		TreeNode node=new TreeNode(3);
		node.right=new TreeNode(1);
		node.right.left=new TreeNode(1);
		node.right.right=new TreeNode(0);
		node.left=new TreeNode(5);
		node.left.left=new TreeNode(6);
		node.left.right=new TreeNode(2);
		node.left.right.left=new TreeNode(7);
		node.left.right.right=new TreeNode(4);
		
		l.lowestCommonAncestor(node, node.left.left, node.left.right.right);
		
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return LCA(root, p, q);

	}

	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}

		TreeNode a = LCA(root.left, p, q);

		TreeNode b = LCA(root.right, p, q);
		if (b == null)
			return a;
		if (a == null)
			return b;

		return root;
	}
}
