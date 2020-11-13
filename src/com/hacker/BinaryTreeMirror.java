package com.hacker;

public class BinaryTreeMirror {
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

	private static int findMirror(Node left, Node right, int target) {
		if (left == null) {
			return 0;
		}
		if (right == null) {
			return 0;
		}

		if (left.data == target) {
			return right.data;
		}
		if (right.data == target) {
			return left.data;
		}
		int value = findMirror(left.left, right.right, target);
		if(value!=0) {
			return value;
		}
		
		return findMirror(left.right, right.left, target);

	}

	public static void main(String[] args) {
		root = new Node(1);
		root.right = new Node(3);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.left.right = new Node(7);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);
		int target = root.left.left.data;

		int mirror = findMirror(root.left, root.right, target);

		if (mirror != 0)
			System.out.println("Mirror of Node " + target + " is Node " + mirror);
		else
			System.out.println("Mirror of Node " + target + " is null ");

	}

}
