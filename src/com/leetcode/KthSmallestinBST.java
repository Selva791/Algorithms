package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestinBST {
		static TreeNode root;
		static class TreeNode {
			int val;
			TreeNode left, right;

			public TreeNode(int item) {
				val = item;
				left = right = null;
			}
		}
		List<Integer>li=new ArrayList<Integer>();

		public static void main(String[] args) {
			root=new TreeNode(5);
			root.left=new TreeNode(3);
			root.left.right=new TreeNode(4);

			root.left.left=new TreeNode(2);
			root.left.left.left=new TreeNode(1);

			root.right=new TreeNode(6);
			KthSmallestinBST c=new KthSmallestinBST();
			System.out.println(c.kthSmallest(root,3));

			//Stack<Integer> st=new Stack<>(li.);
			


		}
	
	public int kthSmallest(TreeNode root,int k) {
	       smallest(root);
	       return li.get(k-1);
	       
	        
	    }
	    public void smallest(TreeNode root){
	        if(root==null){
	            return;
	            
	        }
	      
	        smallest(root.left);
	        li.add(root.val);
	        smallest(root.right);

	       
	        
	    }
}
