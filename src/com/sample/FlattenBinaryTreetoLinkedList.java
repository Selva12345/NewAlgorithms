package com.sample;

public class FlattenBinaryTreetoLinkedList {
	public static void main(String[] args) {
		FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		f.flatten(root);

	}

	public void flatten(TreeNode root) {
		TreeNode result = new TreeNode(0);
		TreeNode temp = treeFlatten(root, result);
		root = temp;
	}

	private TreeNode treeFlatten(TreeNode root, TreeNode result) {
		if (root == null) {
			return null;
		}
		// System.out.println(root.val);
		TreeNode node = null;

		TreeNode left = treeFlatten(root.left, result);
		TreeNode right = treeFlatten(root.right, result);
		if (root != null) {
			root.left = null;
			root.right = left;
		}
		if (left != null) {
			left.right = right;
			return root;
		}
		if (left == null && right != null) {
			root.right = right;
		}

		return root;

	}
}
