package com.hacker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
public class BinaryTreeDiagonal {
	Node root;

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

		public static void main(String[] args) {
			BinaryTreeDiagonal bd = new BinaryTreeDiagonal();
			Node root = new Node(8);
			root.left = new Node(3);
			root.right = new Node(10);
			root.left.left = new Node(1);
			root.left.right = new Node(6);
			root.right.right = new Node(14);
			root.right.right.left = new Node(13);
			root.left.right.left = new Node(4);
			root.left.right.right = new Node(7);
			diagonalPrint(root);

		}

	private static void diagonalPrint(Node root) {
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		Queue<Node> q1=new LinkedList<Node>();
q1.add(root);
		List<Integer> li=new ArrayList<Integer>();
		List<Integer> lir=new ArrayList<Integer>();
		lir.add(root.data);
		while(!q.isEmpty()) {
			
			Node newNode=q.poll();
			if(newNode.right!=null) {
				q1.add(newNode.right);
				q.add(newNode.right);
				lir.add(newNode.right.data);
				
			}
			
		}
		while(!q1.isEmpty()) {
			
			Node newNode=q1.poll();
			if(newNode.left!=null) {
				if(!q1.contains(newNode.left)) {
					q1.add(newNode.left);

					li.add(newNode.left.data);	

				}
				if(newNode.right!=null) {
					if(!q1.contains(newNode.right)) {

					q1.add(newNode.right);
					li.add(newNode.right.data);	
					}
				}
			}
			
			
		}
	}

	}

}
