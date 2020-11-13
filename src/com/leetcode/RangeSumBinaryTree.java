package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

//https://leetcode.com/problems/range-sum-of-bst/
public class RangeSumBinaryTree {
	 static int count=0;
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
	    	root=new TreeNode(10);
			root.left=new TreeNode(5);
			root.right=new TreeNode(15);
			root.left.left=new TreeNode(3);
			root.left.right=new TreeNode(7);
			
			root.right=new TreeNode(15);
			root.right.right=new TreeNode(18);
			/*root=new TreeNode(10);
			root.left=new TreeNode(5);
			root.right=new TreeNode(15);
			root.left.left=new TreeNode(3);
			root.left.left.left=new TreeNode(1);
			root.left.right=new TreeNode(7);
			root.left.right.left=new TreeNode(6);
			
			root.right=new TreeNode(15);
			root.right.left=new TreeNode(13);
			root.right.right=new TreeNode(18);*/
			RangeSumBinaryTree rt=new RangeSumBinaryTree();
			rt.rangeSumBST(root, 7, 15);
			
Map<Integer, Integer> mp=new HashMap<Integer, Integer>();
int y=0;
//	mp.values().stream().max(comparator::Integer);
Stream<Entry<Integer, Integer>> retult = mp.entrySet().stream().filter(s->s.getValue()==y);
	
		}
	   // static int s1=0;
	    public int rangeSumBST(TreeNode root, int L, int R) {
 	       // TreeNode lca=LCA(root,L,R);
	       // int s1=rangeSum(lca,L,0);
	        
	        return rangeSum(root,L,R);
	    }
	    public int rangeSum(TreeNode lca,int L,int R){
 	        if(lca==null){
	           return 0; 
	        }
 	        int s1=0;
	        if(lca.val>=L&&lca.val<=R) {
	        s1=lca.val;
	        }
	        if(lca.val>L)
	       s1+=rangeSum(lca.left,L,R);
	       if(lca.val<R)
	       s1+= rangeSum(lca.right,L,R);       
	    
	        return s1;
	    }
	    public TreeNode LCA(TreeNode node,int L,int R){
	        if(node==null){
	            return null;
	        }
	        if(node.val==L||node.val==R){
	            return node ;
	            
	        }
	       TreeNode left= LCA(node.left,L,R);
	        TreeNode right=LCA(node.right,L,R);
	        if(left!=null&&right!=null){
	            return node;
	        }
	        return left==null?right:left;
	    }
}
