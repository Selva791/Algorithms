package com.hacker;

import com.hacker.BinaryTreeDiagonal.Node;
//https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/

public class BinaryTreeGreaterSum {
	static Node root;

	public static void main(String[] args) {
		BinaryTreeGreaterSum tree = new BinaryTreeGreaterSum();

		/*
		 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
		 */

		tree.root = tree.insert(50, tree.root);
		tree.root = tree.insert(30, tree.root);
		tree.root = tree.insert(20, tree.root);
		tree.root = tree.insert(40, tree.root);
		tree.root = tree.insert(70, tree.root);
		tree.root = tree.insert(60, tree.root);
		tree.root = tree.insert(80, tree.root);

		// modifyBST(root,0,0);

		inorder(root);
	}

	private static void inorder(Node root2) {
		if (root2 == null)
			return;
		int g = modifyBST(root, root2.data, 0);
		root2.data = g;
		inorder(root2.left);
System.out.println(root2.data);
		inorder(root2.right);

	}

	private static int modifyBST(Node root2, int d, int y) {
		if (root2 == null)
			return y;

		if (root2.data > d) {
			y = y + root2.data;
			modifyBST(root2.left, d,y);

		}
		if (root2.data < d) {
			modifyBST(root2.right, d, y);

		} else if (root2.data == d) {
			y = d;
			modifyBST(root2.right, d, y);

		}
		return y;

	}

	private Node insert(int i, Node rooter) {
		if (rooter == null)
			return rooter = new Node(i);

		if (rooter.data < i) {
			rooter.right = insert(i, rooter.right);
		}
		if (rooter.data > i) {
			rooter.left = insert(i, rooter.left);

		}
		return rooter;

	}
}
