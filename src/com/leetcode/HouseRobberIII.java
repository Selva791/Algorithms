package com.leetcode;

public class HouseRobberIII {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(5);
		root.right=new TreeNode(5);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(1);
		root.right.right=new TreeNode(9);
		HouseRobberIII h=new HouseRobberIII();
		System.out.println("Answer: "+h.rob(root));
	}
	public int rob(TreeNode root) {
	    if (root == null) return 0;
	    
	    int val = 0;
	    
	    if (root.left != null) {
	        val += rob(root.left.left) + rob(root.left.right);
	    }
	    
	    
	    if (root.right != null) {
	        val += rob(root.right.left) + rob(root.right.right);
	    }
	    int a=val+root.val;
	    int b=rob(root.left) + rob(root.right);
	    System.out.println(a+"  "+b);
	    int c=Math.max(a, b);
	    return c;
	}
}
