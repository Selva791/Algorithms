package com.hacker;

import java.util.LinkedList;
import java.util.Queue;

// edges u v should not have same colour(0,1 ->two colours).In below problem value 1 
// from matrix are nodes of graph
public class IsBiPartieGraph {
public static void main(String[] args) {
	  int G[][] = {
			  {0, 1, 1, 0}, 
              {1, 0, 0, 1}, 
              {1, 0, 0, 1}, 
              {0, 1, 1, 0}}; 
                
        if (isBipartite(G)) 
           System.out.println("Yes"); 
        else
           System.out.println("No"); 
}

private static boolean isBipartite(int[][] g) {
	// TODO Auto-generated method stub
	int [] colour=new int[g.length];
	for (int i = 0; i < g.length; i++) {
		colour[i]=-1;
	}
	for (int i = 0; i < colour.length; i++) {
		if(colour[0]==-1) {
			if(isBipartieGraph(g,0,colour)==false) {
				return false;
			}
			
		}
	}
	return true;
}

private static boolean isBipartieGraph(int[][] g, int src, int[] colour) {
	// TODO Auto-generated method stub
	colour[src]=1;
	Queue<Integer> q=new LinkedList<Integer>();
	q.add(src);
	while(!q.isEmpty()) {
		int u=q.poll();
		
		//self loop is not accepted in BiePartie graph bcs we cant have same colour
		if(g[u][u]==1) {
			return false;
		}
		for (int v = 0; v <g.length; v++) {
			
			if(g[u][v]==1&& colour[v]==-1) {
				colour[v]=1-colour[u];
				q.add(v);
			}else if(g[u][v]==1&&colour[v]==colour[u]) {
				return false;
			}
		}
	}
	
	
	
	
	return true;
}
}
