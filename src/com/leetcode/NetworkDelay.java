package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelay {
	public static void main(String[] args) {
		NetworkDelay nd = new NetworkDelay();
		int times[][] = {{2,1,1},{2,3,1},{3,4,1}};
		
		int N = 4;
		int K = 2;
		System.out.println(nd.networkDelayTime(times, N, K));
	}

	public int networkDelayTime(int[][] times, int N, int K) {
		int n1 = times.length;
		int n2 = times[0].length;

		if (n1 == 0 && n2 == 0)
			return 0;
		int graph[][] = new int[N + 1][N + 1];
			for(int d[]:graph) {
				Arrays.fill(d,Integer.MAX_VALUE);
			}
		for (int temp[] : times) {
			graph[temp[0]][temp[1]] = temp[2];
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		boolean visited[] = new boolean[N + 1];
		visited[0] = true;
		int count[] = new int[N + 1];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[0] = 0;
		count[K]=0;
		pq.add(new int[] { K, 0 });
		while (!pq.isEmpty()) {
			int c[] = pq.poll();
			int start = c[0];
			if (visited[start])
				continue;

			int m = c[1];


			visited[start] = true;
			
			for (int i = 1; i <= N; i++) {
				if (visited[i])
					continue;
				
				if (graph[start][i]!=Integer.MAX_VALUE) {
					
					count[i] = Math.min(m + graph[start][i], count[i]);

					
				}
				pq.add(new int[] { i, count[i] });


			}
		}
		int g = Integer.MIN_VALUE;
		for (int t : count) {
			if (t == Integer.MAX_VALUE)
				return -1;
		g=Math.max(g, t);

		}
		return g;

	}
}
