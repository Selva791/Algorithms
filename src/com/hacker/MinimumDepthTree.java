package com.hacker;
//https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
public class MinimumDepthTree {
	Node root;
	static class Node{
		int data;
		Node left,right;
		Node(int val){
			data=val;
			left=right=null;
			
		}
	}
public static void main(String[] args) {
	MinimumDepthTree tree = new MinimumDepthTree(); 
    tree.root = new Node(1); 
    tree.root.left = new Node(2); 
    tree.root.right = new Node(3); 
    tree.root.left.left = new Node(4); 
    tree.root.left.right = new Node(5); 

    System.out.println("The minimum depth of "+ 
      "binary tree is : " + tree.minimumDepth()); 
}
private int minimumDepth() {
	int s=minimumDepth(root);
	//System.out.println(s);
	return s;
}
private int minimumDepth(Node node) {
	if(node==null) {
		return 0;
	}
	
	return Integer.min(1+minimumDepth(node.left), 1+minimumDepth(node.right));
}

}
