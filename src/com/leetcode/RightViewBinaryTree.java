package com.leetcode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-right-side-view/submissions/
public class RightViewBinaryTree {
	TreeNode root;
	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}
public static void main(String[] args) {
	//root=new TreeNode(item);
	//Character.i
}
static List<Integer> view;
static int max;
 
RightViewBinaryTree(){
     max=0;
     view=new ArrayList<>();
 }
 public List<Integer> rightSideView(TreeNode root) {
     rightView(root,1);
     return view;
     
 }
 public void rightView(TreeNode node,int level){
     if(node==null){
         return;
     }
     if(max<level){
         max=level;
          view.add(node.val);   
     }
  
     
     rightView(node.right,level+1);
    
     rightView(node.left,level+1);
      
     
 }
}
