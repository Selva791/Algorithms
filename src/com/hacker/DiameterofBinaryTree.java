package com.hacker;

public class DiameterofBinaryTree {
	static Node root;
	static class Node{
		int data;
		Node left,right;
		Node(int val){
			data=val;
			left=right=null;
		}
	} 
	static class A{
		int ans =Integer.MIN_VALUE;
	}
public static void main(String[] args) {
	DiameterofBinaryTree tree = new DiameterofBinaryTree(); 
    root = new Node(1); 
    root.left = new Node(2); 
    root.right = new Node(3); 
    root.left.left = new Node(4); 
  //  root.left.left.left = new Node(6); 
  //  root.left.left .left.left= new Node(9); 

    root.left.right = new Node(5);
   // root.left.right.right = new Node(7); 
  //  root.left.right.right.right = new Node(10); 

    	A a =new A();
    System.out.println("The length of given  tree is : "
    		 ); 
    tree.diameter(root,a);
    System.out.println("Diameter :"+a.ans);
}
private int diameter(Node root2,A a) {
	if(root2==null)
		return 0;
	
	int heightl=diameter(root2.left,a);
	int heightr=diameter(root2.right,a);
	a.ans=Math.max(a.ans, 1+heightl+heightr);//max concept used get maximum lenght or diameter during each recursion
	return 1+Math.max(heightl, heightr);
	
}
}
