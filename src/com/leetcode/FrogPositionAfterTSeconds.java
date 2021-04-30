package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrogPositionAfterTSeconds {
	public static void main(String[] args) {
		FrogPositionAfterTSeconds f = new FrogPositionAfterTSeconds();

		int edges[][] = { { 1, 2 }, { 1, 3 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 3, 5 } };
		// {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
		int n = 7, t = 20, target = 6;
		System.out.println(f.frogPosition(n, edges, t, target));
	}

	Map<Integer, List<Integer>> mp;

	public double frogPosition(int n, int[][] edges, int t, int target) {
		mp = new HashMap<>();
		for (int v[] : edges) {
			mp.computeIfAbsent(v[0], h -> new ArrayList<Integer>()).add(v[1]);
			mp.computeIfAbsent(v[1], h -> new ArrayList<Integer>()).add(v[0]);
		}

		boolean visited[] = new boolean[n + 1];
		visited[1] = true;
		double res = frogJump(1, visited, t, target, -1);
		if (res >= 0.0) {
			return res;
		}

		return 0.0;

	}

	public double frogJump(int v, boolean visited[], int s, int target, int prev) {
		if(mp.get(v).size()==1||s==0) {
			if(v==target) {
				return 1;
			}
		}
	
		if (s == 0)
			return -1;

		for (int val : mp.get(v)) {
			if (!visited[val]) {
				visited[val] = true;
				double size = 0.0;
				if (prev == -1) {
					size = mp.get(v).size();
				} else if (prev != -1) {
					size = mp.get(v).size() - 1;
				}
				double r = frogJump(val, visited, s - 1, target, v);
				if (r != -1) {
					double f = 1.0 / size;
					r = (f) * r;
					return r;
				}

			}
		}
		return -1;
	}
}
