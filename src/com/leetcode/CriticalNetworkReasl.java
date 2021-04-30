package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CriticalNetworkReasl {
	public static void main(String[] args) {
		List<List<Integer>> connections = new ArrayList<>();
		connections.add(Arrays.asList(0, 1));
		connections.add(Arrays.asList(1, 2));
		connections.add(Arrays.asList(2, 0));
		connections.add(Arrays.asList(1, 3));
		connections.add(Arrays.asList(3, 4));
		connections.add(Arrays.asList(4, 5));
		connections.add(Arrays.asList(5, 3));
		CriticalNetworkReasl c = new CriticalNetworkReasl();

		System.out.println(c.criticalConnections(6, connections));

	}

	List<List<Integer>> ans;
	List<Integer> graph[];

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		ans = new ArrayList<>();
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			List<Integer> val = new ArrayList<>();
			graph[i] = val;
		}
		for (List<Integer> a : connections) {
			graph[a.get(0)].add(a.get(1));
			graph[a.get(1)].add(a.get(0));
		}
		int low[] = new int[n];

		int high[] = new int[n];
		Arrays.fill(low, Integer.MAX_VALUE);
		Arrays.fill(high, -1);
		criticalNetwork(0, n, low, high, -1);
		return ans;
	}

	int key = -1;

	public int criticalNetwork(int i, int n, int low[], int high[], int parent) {
		if (high[i] >= 0) {
			return low[i];
		}

		low[i] = high[i] = ++key;
		for (int val : graph[i]) {

			if (val == parent)
				continue;

			int min = criticalNetwork(val, n, low, high, i);
			
			low[i]=Math.min(low[i], low[val]);

			if (low[val] > low[i]) {
				ans.add(Arrays.asList(i, val));
			}
			

		}
		return low[i];
	}

}
