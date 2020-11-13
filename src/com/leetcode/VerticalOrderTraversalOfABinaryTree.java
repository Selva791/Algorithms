package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class VerticalOrderTraversalOfABinaryTree {
	public static void main(String[] args) {
		VerticalOrderTraversalOfABinaryTree v=new VerticalOrderTraversalOfABinaryTree();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(6);
		
		root.right.right=new TreeNode(7);

		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		

		v.verticalTraversal(root);
	}

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		Map<Integer, TreeSet<int[]>> map = new TreeMap<>(Collections.reverseOrder());
		traverse(map, 0, 0, root);
		System.out.println(map);

		for (int k : map.keySet()) {
			List<Integer> r = new ArrayList<>();
			for (int s[] : map.get(k)) {
				r.add(s[0]);
			}
			result.add(r);
		}
		return result;
	}

	public void traverse(Map<Integer, TreeSet<int[]>> map, int index, int level, TreeNode root) {
		if (root == null) {
			return;
		}
		if (map.get(index) == null) {
			TreeSet<int[]> t = new TreeSet<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
			t.add(new int[] { root.val, level });
			map.put(index, t);
		} else {
			map.get(index).add(new int[] { root.val, level });
		}
		traverse(map, index + 1, level + 1, root.left);
		traverse(map, index - 1, level + 1, root.right);

	}

}
