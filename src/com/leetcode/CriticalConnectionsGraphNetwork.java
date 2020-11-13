package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CriticalConnectionsGraphNetwork {
	public static void main(String[] args) {
		List<List<Integer>> connections = new ArrayList<>();
		connections.add(Arrays.asList(0, 1));
		connections.add(Arrays.asList(1, 2));
		connections.add(Arrays.asList(2, 0));
		connections.add(Arrays.asList(1, 3));
		CriticalConnectionsGraphNetwork c = new CriticalConnectionsGraphNetwork(4);
		c.criticalConnections(4, connections);
		System.out.println(div);
        StringBuilder sb=new StringBuilder("123896");
sb.insert(4, "7");

		//Long s=9876543210L;
	//	String.valueOf(s);
		
	}

	static List<List<Integer>> div = new ArrayList<>();
	LinkedList[] adj;
	int count = 0;
	int low[] ;
	int high[];
	CriticalConnectionsGraphNetwork(int n) {
		low = new int[n];
		high = new int[n];
		adj = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();

		}
	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		for (List<Integer> value : connections) {
			adj[value.get(0)].add(value.get(1));

			adj[value.get(1)].add(value.get(0));

		}
		int m = connections.size();
		boolean visited[] = new boolean[n];
		int parent[] = new int[n];
		int low[] = new int[n];
		int high[] = new int[n];
		Arrays.fill(visited, false);
		Arrays.fill(low, -1);
		Arrays.fill(high, -1);
		Arrays.fill(parent, -1);

		criticalPoints(0, visited, -1);

		return div;

	}

	public void criticalPoints(int current, boolean visited[], int parent) {
		visited[current] = true;
		low[current]=high[current]=count++;
		Iterator<Integer> itr=adj[current].iterator();
			while(itr.hasNext()) {
				int value=itr.next();
				if(value==parent) {
					continue;
				}
				if(!visited[value]) {					

					criticalPoints(value,visited,current);
					low[current]=Math.min(low[current], low[value]);
					if(low[value]>high[current]) {
						div.add(Arrays.asList(current,value));
						
					}
									
					
				}else {
					low[current]=Math.min(low[current], high[value]);
				}
				
			}
	}
}
