package com.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalNetworkConnections {
	List<List<Integer>> div = new ArrayList<>();
	List<Integer>[] adj;
	int count;
	int low[];
	int high[];

	public static void main(String[] args) {
		CriticalNetworkConnections cn = new CriticalNetworkConnections();
		List<List<Integer>> connections = new ArrayList<>();
		//{{1, 2},{2, 3},{4, 3},{4, 5},{5, 7},{6, 7},{7, 8}}		
		connections.add(Arrays.asList(1, 2));
		connections.add(Arrays.asList(2, 3));
		connections.add(Arrays.asList(4, 3));
		connections.add(Arrays.asList(4, 5));
		connections.add(Arrays.asList(5, 7));
		connections.add(Arrays.asList(6, 7));
		connections.add(Arrays.asList(7, 8));


		System.out.println(cn.criticalConnections(9, connections));
	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		
		adj = new ArrayList[n];
		low=new int[n];
		high=new int[n];
		
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		for (List<Integer> list : connections) {

			adj[list.get(0)].add(list.get(1));
			adj[list.get(1)].add(list.get(0));

		}
		boolean visited[] = new boolean[n];
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				failCheck(visited, i, -1);//for loop cover all nodes 

			}
		}
		return div;

	}

	public void failCheck(boolean[] visited, int next, int parent) {
		List<Integer> cur = adj[next];
		visited[next] = true;
		low[next]=high[next]=count++;
		for (Integer value : cur) {
			if (parent == value) {
				continue;
			}
			if (!visited[value]) {
				
				failCheck(visited, value, next);
				low[next]=Math.min(low[next], low[value]);

				if(low[value]>high[next]) {
					div.add(Arrays.asList(value,next));
				}
			}else {
				low[next]=Math.min(low[next],high[value]);
			}

		}

	}

}
