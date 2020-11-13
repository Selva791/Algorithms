package com.hacker;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfTreeTry {
	Node root;

	static class Node {
		int value;
		Node left, right;

		Node(int d) {
			value = d;
			left = right = null;

		}
	}

	void topView(Node root2) {
		class create {
			int h;
			Node num;

			create(Node n, int d) {
				num = n;
				h = d;

			}
		}
		Map<Integer, Integer> mp = new TreeMap<>();
		Queue<create> cq = new LinkedList<>();
		cq.add(new create(root2, 0));

		while (!cq.isEmpty()) {
			create t = cq.poll();
			if (!mp.containsKey(t.h)) {

			mp.put(t.h, t.num.value);
			}

			if (t.num.left != null) {
				cq.add(new create(t.num.left, t.h + 1));

			}
			if (t.num.right != null) {
				cq.add(new create(t.num.right, t.h - 1));
			}

		}
		System.out.println(mp);
	}

	public static void main(String[] args) {
		TopViewOfTreeTry ht = new TopViewOfTreeTry();
		ht.root = new Node(5);
		ht.root.left = new Node(2);
		ht.root.right = new Node(3);
		ht.root.left.right = new Node(4);
		ht.root.left.right.right = new Node(5);
		ht.root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in top view of Binary Tree");
		ht.topView(ht.root);

	}

}
