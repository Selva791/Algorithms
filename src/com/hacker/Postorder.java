package com.hacker;

import java.math.BigDecimal;
import java.util.Scanner;

public class Postorder {
	static Node root;

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	/*
	 * you only have to complete the function given below. Node is defined as
	 * 
	 * class Node { int data; Node left; Node right; }
	 * 
	 */

	public void postOrder(Node root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data);

	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Postorder d = new Postorder();
		root = insert(root, 1);
		root = insert(root, 2);
		root = insert(root, 5);
		root = insert(root, 3);
		root = insert(root, 4);
		root = insert(root, 6);

		d.postOrder(root);
	}
}
