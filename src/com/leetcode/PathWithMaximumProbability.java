package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {
	public static void main(String[] args) {
		PathWithMaximumProbability p = new PathWithMaximumProbability();
		int[][] edg = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
		double succ[] = { 0.5, 0.5, 0.2 };
		int s = 0, end = 2, n = 3;
		System.out.println(p.maxProbability(n, edg, succ, s, end));
	}

	class Pair {
		int a;
		double b;

		public Pair(int a, double b) {
			this.a = a;
			this.b = b;
		}
	}

	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Map<Integer,List<int[]>> graph=new HashMap<>();
		for (int i = 0; i < succProb.length; i++) {
			succProb[i] = Math.log(succProb[i]);
		}
		
		for (int i = 0; i < edges.length; i++) {
			int k=edges[i][0]; int val=edges[i][1];
			graph.computeIfAbsent(k, v->new ArrayList<int[]>()).add(new int[] {val,i});
			graph.computeIfAbsent(val, v->new ArrayList<int[]>()).add(new int[] {k,i});
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (Double.compare(b.b, a.b)));

		pq.offer(new Pair(start, 0.0));
		boolean[] visited = new boolean[n];

		while (!pq.isEmpty()) {
			Pair pr = pq.poll();
			int s = pr.a;
			if (visited[s])
				continue;

			visited[s] = true;

			if (s == end)
				return Math.exp(pr.b);
			
			if(graph.get(s)==null)continue;
			
			for (int a[]:graph.get(s)) {
				if (visited[a[0]])
					continue;
				
					double v = succProb[a[1]];
					pq.offer(new Pair(a[0], pr.b + v));
				
			}
		}
		return 0;
	}
}
