package com.Amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinCostToRepairEdges {
	public static int minCost(int n, int[][] edges, int[][] edgesToRepair) {
		if (n == 0)
			return -1;
		int[] roots = new int[n + 1];// id -> index + 1
		Arrays.fill(roots, -1);
		Set<String> check = new HashSet<>();
		for (int[] ed : edgesToRepair) {
			check.add(Arrays.toString(Arrays.copyOfRange(ed, 0, 2)));

		}

		for (int[] edge : edges) {
			if (check.contains(Arrays.toString(edge))) {
				continue;

			}
			int left = find(roots, edge[0]);
			int right = find(roots, edge[1]);
			if (right != left) {
				roots[left] = right;
				n--;
			}

		}
		Arrays.sort(edgesToRepair, (a, b) -> a[2] - b[2]);
		int res = 0;
		for (int value[] : edgesToRepair) {
			if (n == 1)
				break;;

			int left = find(roots, value[0]);
			int right = find(roots, value[1]);
			if (right != left) {
				roots[left] = right;
				res += value[2];
				n--;
			}

		}

		return n==1?res:-1;

	}

	private static int find(int[] roots, int i) {
		if (roots[i] < 0) {
			return i;

		}
		return find(roots, roots[i]);
	}

	public static void main(String[] args) {
		int[][] edges = new int[][] { { 1, 2 }, { 2, 3 }, { 4, 5 }, { 3, 5 } };
		int[][] repair = new int[][] { { 1, 6, 410 }, { 2, 4, 800 } };
		System.out.println(minCost(6, edges, repair));

		edges = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } };
		repair = new int[][] { { 1, 2, 12 }, { 3, 4, 30 }, { 1, 5, 8 } };
		System.out.println(minCost(5, edges, repair));
	}
}
