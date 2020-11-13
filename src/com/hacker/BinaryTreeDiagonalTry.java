package com.hacker;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.hacker.BinaryTreeDiagonal.Node;

public class BinaryTreeDiagonalTry {
	Node root;

	public static void main(String[] args) {
		BinaryTreeDiagonalTry bd = new BinaryTreeDiagonalTry();
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);
		Map<Integer, Vector<Integer>> mp = new HashMap<>();

		diagonalPrint(root,0,mp);
		System.out.println(mp);
	}

	private static void diagonalPrint(Node root2, int d, Map<Integer, Vector<Integer>> mp) {
		if(root2==null)return;
		
		Vector<Integer> vc=mp.get(d);
		
		if(vc==null) {
			vc=new Vector<>();
			vc.add(root2.data);
			
		}else {
			vc.add(root2.data);
			
		}
		
		mp.put(d,vc);
		diagonalPrint(root2.left,d+1,mp);
		
		diagonalPrint(root2.right,d,mp);

		
	}

}
