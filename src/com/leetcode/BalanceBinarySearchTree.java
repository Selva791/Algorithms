package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {
	public static void main(String[] args) {
		BalanceBinarySearchTree b=new BalanceBinarySearchTree();
		TreeNode root=new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.right=new TreeNode(3);
		root.right.right.right=new TreeNode(5);
		root.right.right.right.left=new TreeNode(4);
		root.right.right.right.right=new TreeNode(6);
		b.balanceBST(root);
			
	}
	    List<TreeNode> sortedArr = new ArrayList<>();
	    public TreeNode balanceBST(TreeNode root) {
	        inorderTraverse(root);
	        return sortedArrayToBST(0, sortedArr.size() - 1);
	    }
	    void inorderTraverse(TreeNode root) {
	        if (root == null) return;
	        inorderTraverse(root.left);
	        sortedArr.add(root);
	        inorderTraverse(root.right);
	    }
	    TreeNode sortedArrayToBST(int start, int end) {
	        if (start > end) return null;
	        int mid = (start + end) / 2;
	        //123456
	        TreeNode root = sortedArr.get(mid);
	        System.out.print(root.val+" ");
	        root.left = sortedArrayToBST(start, mid - 1);
	        root.right = sortedArrayToBST(mid + 1, end);
	        return root;
	    }
	
	/*int makeVine(TreeNode grand) {
		  int cnt = 0;
		  TreeNode n = grand.right;
		  while (n != null) {
		    if (n.left != null) {
		    	TreeNode old_n = n;
		      n = n.left;
		      old_n.left = n.right;
		      n.right = old_n;
		      grand.right = n;
		    }
		    else {      
		        ++cnt;
		        grand = n;
		        n = n.right;
		    }
		  }
		  return cnt;
		}
		void compress(TreeNode grand, int m) {
			TreeNode n = grand.right;
		  while (m-- > 0) {
			  TreeNode old_n = n;
		    n = n.right;
		    grand.right = n;
		    old_n.right = n.left;
		    n.left = old_n;
		    grand = n;
		    n = n.right;
		  }
		}    
		public TreeNode balanceBST(TreeNode root) {
		  TreeNode grand = new TreeNode(0);
		  grand.right = root;
		  int cnt = makeVine(grand);
		  int m = (int)Math.pow(2, (int)(Math.log(cnt + 1) / Math.log(2))) - 1;
		  compress(grand, cnt - m);
		  for (m = m / 2; m > 0; m /= 2)
		    compress(grand, m);
		  return grand.right;
		}*/
}
