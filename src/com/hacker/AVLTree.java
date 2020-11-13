package com.hacker;


public class AVLTree {
	Node root;

	class Node {
		int val, ht;
		Node left, right;

		Node(int d) {
			val = d;
			ht = 1;
		}
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		/* Constructing tree given in the above figure */
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);
		//int h = height(tree.root);
		//System.out.println(h);
		tree.preOrder(tree.root);

	}
	void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.val + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	private Node insert(Node root2, int i) {
		// TODO Auto-generated method stub
		if (root2 == null)
			return (new Node(i));

		if (root2.val > i) {
			root2.left = insert(root2.left, i);
		} else if (root2.val < i) {
			root2.right = insert(root2.right, i);
		} else {
			return root2;
		}

		root2.ht = 1 + max(ht(root2.left), ht(root2.right));
		int balance = 0;
		if (root2 != null) {
			balance = ht(root2.left) - ht(root2.right);
		}
		if (balance < -1 && root2.right.val < i) {
			return leftrotate(root2);
		} else if (balance > 1 && root2.left.val > i) {
			return rightrotate(root2);
		} else if (balance < -1 && root2.right.val > i) {
			root2.right=rightrotate(root2.right);
			return leftrotate(root2);
		} else if (balance > 1 && root2.left.val < i) {
			root2.left=leftrotate(root2.left);
			return rightrotate(root2);
		}
		return root2;
	}

	private Node rightrotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// Perform rotatio
		x.right = y;
		y.left = T2;

		// Update heights
		y.ht = max(ht(y.left), ht(y.right)) + 1;
		x.ht = max(ht(x.left), ht(x.right)) + 1;

		// Return new root
		return x;
	}

	private Node leftrotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		// Perform rotation
		y.left = x;
		
		x.right = T2;

		// Update heights
		x.ht = max(ht(x.left), ht(x.right)) + 1;
		y.ht = max(ht(y.left), ht(y.right)) + 1;

		// Return new root
		return y;
	}

	private int ht(Node n) {
		if (n == null)
			return 0;

		return n.ht;
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;

	}

	public static int height(Node hello) {
		if (hello == null)
			return 0;

		int lh = height(hello.left) + 1;
		int rh = height(hello.right) + 1;
		if (rh > lh)
			return rh;

		return lh;

	}
}
