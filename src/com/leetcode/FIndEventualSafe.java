package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FIndEventualSafe {
	public static void main(String[] args) {
		FIndEventualSafe f=new FIndEventualSafe();
		int graph[][]= {{0,1,8},{4,5,8},{3,5,6,8},{4,5,6,7,8,9},{5},{},{3,8},{8,9},{9},{8}};
		f.eventualSafeNodes(graph);
	}

	List<Integer> adj[];
	List<Integer> result;

	public List<Integer> eventualSafeNodes(int[][] graph) {
		int n = graph.length;
		result = new ArrayList<>();
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			int temp[] = graph[i];
			for(int j=0;j<temp.length;j++) {
				adj[i].add(temp[j]);
			}
				

		}
		boolean check[]=new boolean[n];
		for (int i = 0; i < n; i++) {

			if (safeNodes(i, new boolean[n],check)) {
				check[i]=true;
				result.add(i);
			}
		}
		return result;
	}

	public boolean safeNodes(int val, boolean visited[],boolean check[]) {
		if (visited[val]) {
			return false;
		}
		if(check[val]) {
			return true;
		}
		visited[val] = true;

		for (int c : adj[val]) {
			if (!safeNodes(c, visited,check)) {
				return false;
			}
		}
		visited[val] = false;
		return true;
	}
}
