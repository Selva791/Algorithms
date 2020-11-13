package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBST {
	public static void main(String[] args) {
		SerializeAndDeserializeBST s=new SerializeAndDeserializeBST();
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(1);
		root.right=new TreeNode(3);
		s.deserialize(s.serialize(root));
	}
	 public String serialize(TreeNode root) {
	        if(root==null){
             return "";
         }
	        Queue<TreeNode> q1=new LinkedList<>();
	            TreeNode temp=null;
	           q1.add(root);
	            StringBuilder sb=new StringBuilder();
	            sb.append(root.val).append("_");
	           while(!q1.isEmpty()) {
	        	   temp=q1.poll();
	        	if(temp.left!=null) {
	        		q1.add(temp.left);
	        		sb.append(temp.left.val).append("_");
	        		
	        	}else {
	        		sb.append("null").append("_");
	        	}
	        	if(temp.right!=null) {
	        		q1.add(temp.right);
	        		sb.append(temp.right.val).append("_");
	        	}else {
	        		sb.append("null").append("_");
	        	}
	        	  
	           }
	        System.out.println(sb);
	        return sb.toString();
	    }
	     
	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
         if(data.equals(""))return null;
	        String s[]=data.split("_");
	        int low=0;
	        int high=s.length;
	        int start=0;
	       List<Integer> d=new ArrayList<>();
	        for(int i=0;i<s.length;i++){
	            if(!s[i].equals("null"))d.add(Integer.valueOf(s[i]));
             else d.add(-1);
	        }

	        TreeNode node=new TreeNode(d.get(0));
	        Queue<TreeNode> q1=new LinkedList<>();
	        q1.add(node);
	        int j=1;
	        while(!q1.isEmpty()&&j<d.size()) {
	        	TreeNode temp=q1.poll();
	        	int l=d.get(j++);
	        	int r=d.get(j++);
	        	if(l!=-1) {
	        		temp.left=new TreeNode(l);
	        		q1.add(temp.left);
	        	}
	        	if(r!=-1) {
	        		temp.right=new TreeNode(r);
	        		q1.add(temp.right);
	        	}
	        }
	        return node;
	    }
	         
	   

}




