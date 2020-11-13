package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CousinBinaryTree {
	static TreeNode root;
	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}
	public static void main(String[] args) {
		root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.right=new TreeNode(5);
		CousinBinaryTree c=new CousinBinaryTree();
		System.out.println(c.isCousins(root,5,4));
		//List<Integer>li=new ArrayList<Integer>();

		//Stack<Integer> st=new Stack<>(li.);
		


	}
	  public boolean isCousins(TreeNode root, int x, int y) {
	       int n=checkCousins(root,x,1);
	        int m=checkCousins(root,y,1);
	        		System.out.println(n+" "+m);

	        if(n==m&&!isCommonParent(root,x,y)){
	            return true;
	        }
	    return false;
	    }
	    public boolean isCommonParent(TreeNode node,int x,int y){
	        if(node ==null){
	            return false;
	        }
	        if((node.left!=null&&node.right!=null)&&(node.left.val==x&&node.right.val==y||node.right.val==x&&node.left.val==y)){
	            return true;
	        }
	        return isCommonParent(node.left,x,y)||isCommonParent(node.right,x,y);
	    }
	    public int checkCousins(TreeNode node,int point,int level){
	        
	        if(node==null){
	            return 0;
	        }
	             

	        if(node.val==point){
	            return level;
	        }
	       int data=checkCousins(node.left,point,level+1);
	        if(data!=0){
	            return data;
	            
	        }
	       return checkCousins(node.right,point,level+1);
	        
	        
	    }
}
