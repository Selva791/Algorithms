package com.leetcode;

public class BinarySearchTreetoGreaterSumTree {
	public static void main(String[] args) {
		BinarySearchTreetoGreaterSumTree b=new BinarySearchTreetoGreaterSumTree();
		TreeNode root =new TreeNode(4);
		root.left=new TreeNode(1);
		root.left.right=new TreeNode(2);
		root.left.right.right=new TreeNode(3);
		root.left.left=new TreeNode(0);
		root.right=new TreeNode(6);
		root.right.left=new TreeNode(5);
		root.right.right=new TreeNode(7);
		root.right.right.right=new TreeNode(8);
		b.bstToGst(root);
	}
	  public TreeNode bstToGst(TreeNode root) {
	        if(root==null){
	            return null;
	        }
	        
	      
	        helper(root,0);
	        
	        return root;
	    }
	    public int helper(TreeNode root,int value){
	        
	            if(root==null){
	                return value;
	            }
	        
	       
	        
	        value=helper(root.right,value);
	       root.val=value+=root.val;
	        
	        value=helper(root.left,value);
	        //System.out.print(root.val+" ");
	        return value;
	        
	    }
}
