package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTree {
	  //Definition for a binary tree node.
	  static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) {
	          this.val = val;
	          this.left = null;
	          this.right = null;
	      }
	  }
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(3);
		root.right=new TreeNode(2);
		root.right.right=new TreeNode(2);

		root.left.left=new TreeNode(5);
		root.left.right=new TreeNode(3);
		MaximumWidthOfBinaryTree m=new MaximumWidthOfBinaryTree();
		System.out.println(m.widthOfBinaryTree(root));
		
	}
	

	 
	    int width=0;
	    Map<Integer,Integer> mp;
	    public int widthOfBinaryTree(TreeNode root) {
	        mp=new HashMap<>();
	        width=0;
	        widthCheck(root,0,0);
	        return width;
	    }
	    public void widthCheck(TreeNode root,int depth,int position){
	        if(root==null){
	            return;
	        }
	        mp.computeIfAbsent(depth,x->position);
	       width= Math.max(width,position-mp.get(depth)+1);
	        widthCheck(root.left,depth+1,position*2);
	        widthCheck(root.right,depth+1,position*2+1);
	        
	    }
	}
