package com.leetcode;

public class RecoverBinarySearchTree {
	public static void main(String[] args) {
		TreeNode t = new TreeNode(2);
		t.right = new TreeNode(1);
		t.left = new TreeNode(3);
		RecoverBinarySearchTree r = new RecoverBinarySearchTree();
		r.recoverTree(t);
	}

	public void recoverTree(TreeNode root) {
		recover(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	TreeNode prev = null;
	TreeNode first = null;
	TreeNode second = null;

	public void recover(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) {
			return;
		}

		if (root.val < min.val) {
			if (second == null)
				second = min;
			
			first = root;

		}
		if (root.val > max.val) {
			if (first == null)
				first = max;
			
			second = root;

		}
		recover(root.left, min, root);
		recover(root.right, root, max);
		return;
	}
}
