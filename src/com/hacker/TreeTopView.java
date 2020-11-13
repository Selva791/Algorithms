package com.hacker;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

import com.hacker.Postorder.Node;

public class TreeTopView {
	Node root;

	public static void topView(Node root) {
		class create {
			Node d;
			int i;

			create(Node d, int i) {
				this.d = d;
				this.i = i;
			}
		}

		Map<Integer, Integer> mp = new TreeMap<>();
		Queue<create> cr = new LinkedList<create>();

		cr.add(new create(root, 0));
		//mp.put(0, root.data);

		while (!cr.isEmpty()) {
			create c = cr.poll();

			if (!mp.containsKey(c.i)) {
				mp.put(c.i, c.d.data);
			}
			if (c.d.left != null) {
				cr.add(new create(c.d.left, c.i - 1));
			}
			if (c.d.right != null) {
				cr.add(new create(c.d.right, c.i + 1));
			}
		}
		for (Entry<Integer, Integer> createOne : mp.entrySet()) {
			System.out.println(" "+ createOne.getValue());

		}
	}

/*	public Node insert(Node root, int data) {
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
	}*/

	public static void main(String[] args) {
		TreeTopView fire = new TreeTopView();
		//int t = 5;
		//int f = 0;
		//Node root = null;
		//while (t-- > 0) {
		//	f++;
		//	int de = f;
		//	root = fire.insert(root, de);
	//	}
		fire.root = new Node(1);
		fire.root.left = new Node(2);
		fire.root.right = new Node(3);
		fire.root.left.right = new Node(4);
		fire.root.left.right.right = new Node(5);
		fire.root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in top view of Binary Tree");
		fire.topView(fire.root);

		// topView(root);

	}
}
