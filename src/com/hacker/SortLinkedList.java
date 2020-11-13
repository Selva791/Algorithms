package com.hacker;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//convert sorted linked list in BST(Binary Search Tree)
public class SortLinkedList {
	Node root;

	class Node {
		Node left, right;
		int data;

		Node(int i) {
			data = i;
			right = left = null;
		}
	}

	public static void main(String[] args) {
		List<Integer> lin = new LinkedList<>();
		lin.add(4);
		lin.add(5);
		lin.add(6);
		lin.add(8);
		lin.add(19);
		lin.add(20);
		SortLinkedList d = new SortLinkedList();
		d.seperate(lin);
		levelOrder(d.root);
	}

	private static void levelOrder(Node root2) {
		if (root2 == null)
			return;

		System.out.println(root2.data);
		levelOrder(root2.left);
		levelOrder(root2.right);
	}

	Node fun(int val, Node n) {

		if (n == null) {
			n = new Node(val);
			return n;

		} else if (n.data < val) {
			n.right = fun(val, n.right);

		} else if (n.data > val) {
			n.left = fun(val, n.left);
		}
		return n;

	}

	private void seperate(List<Integer> lin) {
		int l = lin.size() / 2;
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		for (int i = l; i >= 0; i--) {
			q1.add(lin.get(i));
		}
		for (int i = l + 1; i < lin.size(); i++) {
			q2.add(lin.get(i));
		}
		int x, y;
		while (!q1.isEmpty() || !q2.isEmpty()) {
			if (!q1.isEmpty()) {
				root = fun(q1.poll(), root);

			}
			if (!q2.isEmpty()) {
				root = fun(q2.poll(), root);
			}
		}

	}
}
