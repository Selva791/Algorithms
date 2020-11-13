package com.leetcode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorder {
	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorder c=new ConstructBinaryTreeFromInorderAndPostorder();
		int in[]= {2,3,4,5,6};//{9,3,15,20,7};
		int pre[]={2,4,3,6,5};//{9,15,7,20,3};
		c.buildTree(in, pre);
	}
	private int pS = 0;
	   public TreeNode buildTree(int[] inorder, int[] postorder) {
	       int len = inorder.length;
	       pS = len-1;
	       return buildTree(inorder, 0, len-1, postorder);
	   }
	   
	    private TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder) {
	        if(iEnd < iStart || iStart < 0) return null;
	        TreeNode root = new TreeNode(postorder[pS]);
	        pS--;
	        int index = -1;
	        for(int i=iStart;i<=iEnd;i++){
	            if(inorder[i] == root.val) {
	                index = i;
	                break;
	            }
	        }
	        root.right = buildTree(inorder, index+1, iEnd, postorder);
	        root.left = buildTree(inorder, iStart, index-1, postorder);
	       
	        return root;
	    }
}
