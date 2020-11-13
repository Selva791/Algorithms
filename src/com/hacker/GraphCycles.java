package com.hacker;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

//https://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
public class GraphCycles {
	static LinkedList<Integer> adj[];
	static int value;

	GraphCycles(int v) {
		value = v;
		adj = new LinkedList[value];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		GraphCycles gc = new GraphCycles(4);
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 0);
		addEdge(2, 3);
		addEdge(3, 3);
		boolean []visited=new boolean[value];

		fun(adj,0,visited);
	}

	private static void fun(LinkedList<Integer>[] adj2,int  i,boolean []visited) {
		
		visited[i]=true;
		
		ListIterator<Integer> lit=adj2[i].listIterator();
		while(lit.hasNext()) {
			int e=lit.next();
			System.out.println(e);

			if(!visited[e]) {
				visited[e]=true;
				fun(adj2,e,visited);				
			}	else {
				
			}
		}
		
			
		
		
		
	}

	private static void addEdge(int i, int j) {
		adj[i].add(j);

	}

}
