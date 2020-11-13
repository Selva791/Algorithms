package com.hacker;

public class BoundaryTraversalBinaryTree {
	Node root;

	static class Node {
		Node left, right;
		int data;

		Node(int value) {
			data = value;
			left = right=null;

		}
	}

	private void printBoundary(Node start) {
		// TODO Auto-generated method stub
		if(start==null) {
			return;
		}
		if(start.left==null&&start.right==null) {
			System.out.println(start.data);

		}
		printBoundary(start.left);
		printBoundary(start.right);

	}

	public static void main(String[] args) {
		BoundaryTraversalBinaryTree tree = new BoundaryTraversalBinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);
		tree.root.right = new Node(22);
		tree.root.right.right = new Node(25);
		System.out.println(tree.root.data);
		tree.letfBoundary(tree.root.left);
		tree.printBoundary(tree.root);
		tree.rightfBoundary(tree.root.right);

	}

	private void rightfBoundary(Node right) {
		// TODO Auto-generated method stub
		if(right.right==null) {
			return;
		}
		System.out.println(right.data);
		rightfBoundary(right.right);
	}

	private void letfBoundary(Node left) {
		// TODO Auto-generated method stub
		if(left.left==null) {
			return;
		}
		System.out.println(left.data);
		rightfBoundary(left.left);
		
	}

}
