package com.leetcode;

public class MiniValueBetweeBSTNodes {
	static TreeNode root;
	  public static class TreeNode {
	      public int val;
	      public TreeNode left;
	      public TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) {
	          this.val = val;
          this.left = null;
         this.right = null;
	      }
	 }
	 
	public static void main(String[] args) {
		MiniValueBetweeBSTNodes mn=new MiniValueBetweeBSTNodes();
			root=new TreeNode(96);
			root.left=new TreeNode(12);
			root.left.right=new  TreeNode(45);
			root.left.right.right=new  TreeNode(90);
			root.left.right.right.left=new  TreeNode(57);
			System.out.println(mn.minDiffInBST(root));

	}
	 
     
    	 Integer prev, ans;
    	    public int minDiffInBST(TreeNode root) {
    	        prev = null;
    	        ans = Integer.MAX_VALUE;
    	        dfs(root);
    	        return ans;
    	    }

    	    public void dfs(TreeNode node) {
    	        if (node == null) return;
    	        dfs(node.left);
    	        if (prev != null)
    	            ans = Math.min(ans, node.val - prev);
    	        prev = node.val;
    	        dfs(node.right);
    	    }
    }

