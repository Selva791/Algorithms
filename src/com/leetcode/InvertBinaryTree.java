package com.leetcode;


public class InvertBinaryTree {
	static TreeNode root;
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	public static void main(String[] args) {
		root=new TreeNode(4);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		root.right=new TreeNode(7);
		root.right.right=new TreeNode(9);
		root.right.left=new TreeNode(6);
		InvertBinaryTree in=new InvertBinaryTree();
		in.invertTree(root);
		


	}
	public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
		TreeNode node=new TreeNode(root.val);
			
       node.right= invert(node.right,root.left);
       node.left=invert(node.left, root.right);
        return node;
        
    }
    public TreeNode invert(TreeNode value, TreeNode node){
        
        if(node==null){
            return null;
        }
      
       if(value==null){
    	   value=new TreeNode();
           
       }
        value.val=node.val;
        value.left= invert(value.left,node.right);
        value.right=invert(value.right,node.left);
     	return value;
        
        
        
    }
}
