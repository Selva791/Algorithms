package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeBT {
	static TreeNode root;

	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}
//[1,2,3,null,null,4,5]
	public static void main(String[] args) {
		root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(1);

		//root.left.left = new TreeNode(3);

		SerializeandDeserializeBT s = new SerializeandDeserializeBT();
		String f = s.serialize(root);
		s.deserialize(f);

	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		String out="";
		String input="null";
		 if(root == null)
	        return out;
		 
		Queue<TreeNode> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode node=q.remove();
			if(node==null) {
				out=out+input+" ";
			}else {
				out=out+node.val+" ";
			}
			if(node!=null) {
			q.add(node.left);
			q.add(node.right);
			}
			
		}
		return out;
	}

	public void preOrder(TreeNode root, List<String> total, int l) {}

	public int findHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lh = findHeight(root.left) + 1;
		int rh = findHeight(root.right) + 1;

		return lh > rh ? lh : rh;

	}

// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.length()==0) {
			return null;
			
		}
		
		String arr[]=data.split(" ");
		Queue<TreeNode> q=new LinkedList<>();
		int n=arr.length; int post=1;
		TreeNode node=new TreeNode(Integer.parseInt(arr[0]));
		q.add(node);
		while(!q.isEmpty()) {
			TreeNode nod=q.poll();
			String left=arr[post++];
			String right=arr[post++];
			if(left.equals("null")) {
				nod.left=null;
			}else {
				nod.left=new TreeNode(Integer.parseInt(left));
				q.add(nod.left);
				
			}
			if(right.equals("null")) {
				
				nod.right=null;
			}else {
				nod.right=new TreeNode(Integer.parseInt(right));
				q.add(nod.right);
			}
		}
		return node;
	}


}

