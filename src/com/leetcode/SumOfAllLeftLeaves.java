package com.leetcode;

public class SumOfAllLeftLeaves {
	public static void main(String[] args) {
		SumOfAllLeftLeaves s=new SumOfAllLeftLeaves();
		TreeNode root =new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		s.sumOfLeftLeaves(root);
        StringBuilder sb=new StringBuilder();
        String st="hh";
        
	}
	  public int sumOfLeftLeaves(TreeNode root) {
	        if(root==null){
	            return 0;
	        }
	        
	        int r= helper(root,0);
	       // r=r-root.val;
	        return r;
	    }
	    public int helper(TreeNode root,int sum){
	         if(root==null){
	            return sum;
	        }
	       
	      
	       
	        sum= helper(root.left,sum);
	       
	        
	        sum= helper(root.right,sum);
	        
	        if(root.left!=null&&root.left.left==null){
	            return sum+root.left.val;
	        }
	        
	        return sum;

	    }

}
