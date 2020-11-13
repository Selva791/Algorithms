package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
	public static void main(String[] args) {
		Node t = new Node(1);
		t.left = new Node(2);
		t.right = new Node(3);
		t.left.left = new Node(4);
		t.left.right = new Node(5);
		t.right.right = new Node(7);
		t.right.left = new Node(6);
		PopulatingNextRightPointersinEachNode p = new PopulatingNextRightPointersinEachNode();
		p.connect(t);
	}

	public Node connect(Node root) {
		// rightSet(root);
		otherSet(root);
		return root;
	}

	public void otherSet(Node value) {

		Queue<Node> q = new LinkedList<>();
		Queue<Node> ans = new LinkedList<>();
		q.add(value);
		while (!q.isEmpty()) {
			Node temp = q.poll();

			if (temp.left != null) {
				q.add(temp.left);
				ans.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
				ans.add(temp.right);

			}

		}
		// ans.poll();
		int index = 2;
		while (!ans.isEmpty()) {

			Node temp = null;
			for (int i = 0; i < index; i++) {
				if (temp == null) {
					temp = ans.poll();

				} else {
					temp.next = ans.poll();
					temp = temp.next;
				}

			}
			index = index * 2;
		}

	}

}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
