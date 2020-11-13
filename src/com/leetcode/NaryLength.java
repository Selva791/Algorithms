package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryLength {
	static Node root;
	static class Node {
		List<Node>children;
		int val;
		Node(int data){
			val=data;
			children=new ArrayList<>();
		}
	}
	public static void main(String[] args) {
		root=new Node(1);
		root.children.add(new Node(3));
		//root.children.add(new Node(2));
		//root.children.add(new Node(4));

		root.children.get(0).children.add(new Node(5));
		//root.children.get(0).children.add(new Node(6));
		System.out.println(maxDepth(root));

	}
	 static int d=0;
	    static int height=0;
	    public static int maxDepth(Node root) {
	        height=0;
	     return depth(root,0);
	    }
	    static int depth(Node root,int length){
	        if(root==null){
	            return 0;
	        }
	          List<Node> nary=root.children;
	          
		        length+=1;

	        for(Node n:nary){
	          depth(n,length);
	        }
	        if(length>height){
                height=length;
            }
	          
	        return height;
	    }
}
