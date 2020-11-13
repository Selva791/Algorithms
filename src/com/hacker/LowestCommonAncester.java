package com.hacker;
//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class LowestCommonAncester {
	 Node root;
	static class Node{
		Node left,right;
		int value;
		Node(int d){
			value=d;
			left=right=null;
			
		}
	}
private String findLCA(int i, int j) {
		
	return String.valueOf(findLCANode(root,i,j).value);
	}

	private Node findLCANode(Node node, int i, int j) {
		
		if(node==null)
			return null;	
		
		if(node.value==i||node.value==j) {
			return node;
		}
		
		Node left=findLCANode(node.left, i, j);
		Node right=findLCANode(node.right, i, j);
		if(left!=null&&right!=null) {
			return node;
			
		}

	return (left!=null)?left:right;
}

	public static void main(String[] args) {
		LowestCommonAncester tree=new LowestCommonAncester();
		 tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	        tree.root.right.left = new Node(6); 
	        tree.root.right.right = new Node(7); 
	  
	        System.out.println("LCA(4, 5): " + tree.findLCA(4,5)); 
	        System.out.println("LCA(4, 6): " + tree.findLCA(4,6)); 
	        System.out.println("LCA(3, 4): " + tree.findLCA(3,4)); 
	        System.out.println("LCA(2, 4): " + tree.findLCA(2,4)); 
	      
	}

	
}
