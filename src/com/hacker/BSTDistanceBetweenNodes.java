package com.hacker;

public class BSTDistanceBetweenNodes {
	static Node root;

	static class Node {
		Node left, right;
		int key;

		// constructor
		Node(int key) {
			this.key = key;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
		System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
		System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));
		System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));
		System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));

	}

	private static String findDistance(Node idea, int i, int j) {
		if (idea == null)
			return "";

		finder(idea, i, 0);
		System.out.println(f);
	Node f=	lowestCommonAncestor(root, i, j);
		System.out.println(f);
		return null;
	}

	static int f = 0;

	private static int finder(Node idea, int i, int h) {
		if (idea == null)
			return 0;
		if (idea.key == i) {
			f = h;
			return 0;
		}

	
			finder(idea.left, i, h + 1);
			finder(idea.right, i, h + 1);

		
		return 0;

	}
//LCA for BST is easy approach**********
	public static Node lowestCommonAncestor(Node rooter, int a, int b) {
		if (rooter == null)
		return null;
		if (rooter.key == a || rooter.key == b) {
			return rooter;
		}
		Node leftNode=lowestCommonAncestor(rooter.left, a, b);

		Node rightNode=lowestCommonAncestor(rooter.right, a, b);
		if(leftNode!=null&& rightNode!=null) {
			return rooter;
		}
		return (leftNode!=null)? leftNode:rightNode;

	}
}
