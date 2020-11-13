package com.hacker;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;
import java.util.Stack;
public class SpiralLevelOrder {
	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int value) {
			data = value;
			left = right = null;
		}
	}

	private void printSpiral(Node root2) {
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		st1.add(root2);

		while (!st1.isEmpty() || !st2.isEmpty()) {
			Node current = null;
			if (!st1.isEmpty()) {
				while (!st1.isEmpty()) {
					current = st1.pop();
					if (current.left != null) {  //Wrong 

						st2.add(current.right);
					}
					if (current.right != null) {

						st2.add(current.left);
					}

					if (current != null) {
						System.out.print(current.data);

					}
				}

			} else {
				while (!st2.isEmpty()) {
					current = st2.pop();
					if (current.left != null) {
						st1.add(current.left);
					}
					if (current.right != null) {
						st1.add(current.right);
					}
					if (current != null) {
						System.out.print(current.data);

					}

				}

			}

		}

	}

	public static void main(String[] args) {
		SpiralLevelOrder tree = new SpiralLevelOrder();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);
		tree.root.right.right.left = new Node(8);

		tree.root.right.right.right = new Node(9);

		System.out.println("Spiral order traversal of Binary Tree is ");
		Map<Integer, Vector<Integer>> mp = new HashMap<Integer, Vector<Integer>>();
		tree.printSpiral(tree.root);
		// System.out.println(mp);

	}

}
