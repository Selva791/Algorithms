package com.leetcode;

import com.leetcode.MiniValueBetweeBSTNodes.TreeNode;

public class SubtreeofAnotherTree {
	static TreeNode root;

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		SubtreeofAnotherTree sb = new SubtreeofAnotherTree();

		TreeNode s = new TreeNode(1);
		s.left = new TreeNode(2);
		s.right = new TreeNode(3);


		// s.left=new TreeNode(4);
		// s.left.left=new TreeNode(1);

		// s.left.right=new TreeNode(2);
		// s.left.left.left=new TreeNode(0);
		TreeNode t = new TreeNode(1);
		// t.right=new TreeNode(2);

		t.left=new TreeNode(2);

		System.out.println(sb.isSubtree(s, t));

	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s==null) {
			return false;
		}
		boolean f=check(s, t);
		if(f) {
			return true;
			
		}
		
		
		return isSubtree(s.left,t)||isSubtree(s.right,t);
	

	}

	public boolean check(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;

		if (s == null || t == null)
			return false;

		boolean value = false;
		if (s.val == t.val) {
			if (check(s.left, t.left)) {
				value = true;
			}
			if (value) {
				value =check(s.right, t.right);

			}
		} else {
			return value;
		}

		return value;

	}

	/*
	  public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null) return false;
        if (same(s,t)) return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);        
    }
    public boolean same(TreeNode s,TreeNode t){
        if(s==null && t==null) return true;
        if (s==null || t==null) return false;
        if (s.val!=t.val) return false;
        return same(s.left,t.left) && same (s.right,t.right);
    }*/

}
