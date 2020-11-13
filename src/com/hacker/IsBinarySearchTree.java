package com.hacker;


public class IsBinarySearchTree {
	Node root;

	static class Node {
		Node right, left;
		int data;

		Node(int d) {
			data = d;
			right = left = null;
		}

	}

	private boolean isBST() {
		
		return bstFinder(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

	}

	private boolean bstFinder(Node root2, int minValue, int maxValue) {
		
		if(root2==null)
			return true;
		
		if(root2.data<=minValue||root2.data>=maxValue) {
			return false;
		}
			
		return(bstFinder(root2.left,minValue,root2.data)&& bstFinder(root2.right, root2.data, maxValue));
	}

	public static void main(String[] args) {
		IsBinarySearchTree tree=new IsBinarySearchTree();
		tree.root = new Node(5); 
        tree.root.left = new Node(2); 
        tree.root.left .right= new Node(3); 
        tree.root.left.left=new Node(1);
        tree.root.right = new Node(8);
        tree.root.right.left= new Node(7);
        tree.root.right.right= new Node(9);
        
     ; 
  
        if (tree.isBST()) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 

	}


}
