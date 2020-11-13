package com.leetcode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public static void main(String[] args) {
		ConstructBinaryTreefromPreorderandInorderTraversal c=new ConstructBinaryTreefromPreorderandInorderTraversal();
		int []preorder = {3,9,20,15,7};
		int []inorder = {9,3,15,20,7};
		c.buildTree(preorder, inorder);
	}
	 int point=0;
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        int n =preorder.length;
	       return tree(preorder,0,n-1,inorder);
	    }
	    public TreeNode tree(int[] preorder,int start,int end, int[] inorder){
	        if(end<start||start<0){
	            return null;
	        }
	        TreeNode root=new TreeNode(preorder[point]);
	        point++;
	        int index=-1;
	        for(int i=start;i<=end;i++){
	            if(inorder[i]==root.val){
	                index=i;
	                break;
	            }
	            
	        }
	       root.left= tree(preorder,start,index-1,inorder);
	       root.right=tree(preorder,index+1,end,inorder);
	        
	        return root;
	        
	    }

}
