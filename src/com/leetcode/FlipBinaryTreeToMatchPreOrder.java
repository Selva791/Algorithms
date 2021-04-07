package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlipBinaryTreeToMatchPreOrder {
	public static void main(String[] args) {
		FlipBinaryTreeToMatchPreOrder f = new FlipBinaryTreeToMatchPreOrder();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int v[] = { 1, 3, 2 };
		System.out.println(f.flipMatchVoyage(root, v));
	}

	 List<Integer> ans;

		public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
			ans = new ArrayList<>();
			// construct(voyage);
			if (root.val != voyage[0]) {
				ans.add(-1);
				return ans;
			}
			flip(root, voyage);
			return ans;
		}

		int pos = 1;

		public boolean flip(TreeNode root, int[] voyage) {

			if (root == null) {
				return true;
			}

			if (root.left!=null&&root.left.val == voyage[pos]) {
				pos++;
				if (!flip(root.left, voyage)) {
					return false;
				}
				if (!flip(root.right, voyage)) {
					return false;
				}
			}else if (root.right!=null&&root.right.val == voyage[pos]) {
				pos++;
				if (!flip(root.right, voyage)) {
					return false;
				}
				if (!flip(root.left, voyage)) {
					return false;
				}
				ans.add(root.val);
			}else if(root.left==null||root.right==null) {
				return true;
			}else {
				ans.add(-1);
				return false;
			}
			
			return true;

		}
}
