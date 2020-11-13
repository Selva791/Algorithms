package com.hacker;

import java.util.Vector;

//NOt finding Diameter--Practise traversal of ALL NODES-OWN ATTEMPT
public class NaryDiameter {
	static Node root;
	static class Node{
		Vector<Node> child;
		char key;
		
		Node(int val){
			
		key=(char)val;
		child=new Vector<>();
			
		}
	}
	//NOt finding Diameter--Practise traversal of ALL NODES-OWN ATTEMPT

	private static String diameter(Node root2) {
		if(root2==null) {
			return "";
		}
		System.out.println(root2.key);
		for (Node dr : root2.child) {
			diameter(dr);
			
		}
		
		return null;
	}
	public static void main(String[] args) {
		 root =new Node('A'); 
	    (root.child).add(new Node('B')); 
	    (root.child).add(new Node('F')); 
	    (root.child).add(new Node('D')); 
	    (root.child).add(new Node('E')); 
	    (root.child.get(0).child).add(new Node('K')); 
	    (root.child.get(0).child).add(new Node('J')); 
	    (root.child.get(2).child).add(new Node('G')); 
	    (root.child.get(3).child).add(new Node('C')); 
	    (root.child.get(3).child).add(new Node('H')); 
	    (root.child.get(3).child).add(new Node('I')); 
	    (root.child.get(0).child.get(0).child).add(new Node('N')); 
	    (root.child.get(0).child.get(0).child).add(new Node('M')); 
	    (root.child.get(3).child.get(2).child).add(new Node('L')); 
	    System.out.print(diameter(root) + "\n"); 

	}
	

}
