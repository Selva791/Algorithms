package com.hacker;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class TopologicalSort {
	LinkedList<Integer> adj[];
int v;
	public TopologicalSort(int n) {
		v=n;
		adj = new LinkedList[v];
		for (int i = 0; i <v; i++) {
			adj[i]=new LinkedList();

		}

	}

	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.topologicalSort();

	}

	private void topologicalSort() {
		Stack<Integer> st=new Stack<>();
		Boolean[] visit=new Boolean[v];
		for (int i = 0; i < visit.length; i++) {
			visit[i]=false;
		}
		for (int i = 0; i < visit.length; i++) {
			//visit[i]=false;
            if (visit[i] == false)
			topoSort(st,i,visit);

		}
		System.out.println(st);
	}

	private void topoSort(Stack<Integer> st, int i, Boolean[] visit) {
		// TODO Auto-generated method stub
		visit[i]=true;
		ListIterator<Integer> lit=adj[i].listIterator();
		while(lit.hasNext()) {
			int t=lit.next();
			//st.push(t);
			if(visit[t]==false) {
				topoSort(st,t,visit);
			}
			
			
		}
		st.push(i);

		
	}

	private void addEdge(int i, int j) {
		adj[i].add(j);

	}

}
