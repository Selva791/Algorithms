package com.revision;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

public class SprialLevelOrder {
	 Node root;
	 static class Node{
		int data;
		Node left,right;
		Node(int value){
			data=value;
			left=right=null;
		}
	}
	
	private void printSpiral(Node root2, int i, Map<Integer, Vector<Integer>> mp) {
		if(root2==null)return;
		Vector<Integer> v=mp.get(i);
		if(v==null) {
			v=new Vector<>();
			
		}
		v.add(root2.data);
		mp.put(i, v);

		printSpiral(root2.left, i+1, mp);

		printSpiral(root2.right, i+1, mp);




		
	}
public static void main(String[] args) {
	SprialLevelOrder tree = new SprialLevelOrder(); 
     tree.root = new Node(1); 
     tree.root.left = new Node(2); 
     tree.root.right = new Node(3); 
     tree.root.left.left = new Node(7); 
     tree.root.left.right = new Node(6); 
     tree.root.right.left = new Node(5); 
     tree.root.right.right = new Node(4); 
     System.out.println("Spiral order traversal of Binary Tree is "); 
     Map<Integer, Vector<Integer>> mp=new HashMap<Integer, Vector<Integer>>();
     tree.printSpiral(tree.root,0,mp); 
    // System.out.println(mp);
     for (Entry<Integer, Vector<Integer>> str : mp.entrySet()) {
    	 if(str.getKey()%2!=0) {
    		 System.out.println(str.getValue());

    	 }else {
    		 System.out.println(new StringBuffer(str.getValue().toString()).reverse());
    	 }
		
	}
}

}
