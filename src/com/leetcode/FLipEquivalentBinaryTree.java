package com.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FLipEquivalentBinaryTree {
	public static void main(String[] args) {
		FLipEquivalentBinaryTree f=new FLipEquivalentBinaryTree();
		TreeNode root1=new TreeNode(1);
		root1.left=new TreeNode(2);
		root1.right=new TreeNode(3);
		root1.right.left=new TreeNode(6);

		root1.left.left=new TreeNode(4);
		root1.left.right=new TreeNode(5);
		root1.left.right.right=new TreeNode(8);
		root1.left.right.left=new TreeNode(7);
        Map<Integer,Set<Integer>> map=new TreeMap<>();
        List<List<Integer>> result=new ArrayList<>();
		TreeNode root2=new TreeNode(1);
		root2.right=new TreeNode(2);
		root2.right.left=new TreeNode(4);

		root2.right.right=new TreeNode(5);
		root2.right.right.right=new TreeNode(7);
		root2.right.right.left=new TreeNode(8);

		f.flipEquiv(root1, root2);
	}
	 public boolean flipEquiv(TreeNode root1, TreeNode root2) {
	        if(root1==null&&root2==null)return true;
	        if(root1==null||root2==null){
	            return false;
	        }
	        if(root1.val!=root2.val)return false;
	        
	        return flip(root1,root2);
	    }
	    public boolean flip(TreeNode root1, TreeNode root2){
	        if(root1==null&&root2==null){
	            return true;
	        }
	        if(root1==null||root2==null){
	            return false;
	        }
	       if(root1.val!=root2.val){
	           return false;
	       }
	        if(flip(root1.left,root2.right)&&flip(root1.right,root2.left)){
	                return true;
	        }if(flip(root1.right,root2.right)&&flip(root1.left,root2.left)) {
	            return true;
	        }
	          return false;

	    }

}
