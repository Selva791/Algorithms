package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalNetworkReasl {
	public static void main(String[] args) {
		List<List<Integer>> connections=new ArrayList<>();
		connections.add(Arrays.asList(0,1));
		connections.add(Arrays.asList(1,2));
		connections.add(Arrays.asList(2,0));
		connections.add(Arrays.asList(1,3));
		CriticalConnectionsGraphNetwork c=new CriticalConnectionsGraphNetwork(4);
		c.criticalConnections(4, connections);
		System.out.println(result);

	}

	static int time=0;

	List<Integer>[] graph;
	static List<List<Integer>> result= new ArrayList<>();
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	    graph = new ArrayList[n];
	    for(int i=0; i<n; i++)
	        graph[i] = new ArrayList<>();
	    for(List<Integer> connection: connections){
	        graph[connection.get(0)].add(connection.get(1));
	        graph[connection.get(1)].add(connection.get(0));
	    }
	    boolean[] visited= new boolean[n];
	    int[] lowTime= new int[n];
	    int[] visitedTime= new int[n];
	    int[] parent= new int[n];
	    Arrays.fill(visited, false);
	    Arrays.fill(visitedTime, -1);
	    Arrays.fill(lowTime, -1);
	    Arrays.fill(parent, -1);
	    
	    for(int i=0; i<n; i++){
	        if(!visited[i]){
	            dfs(i,visited,visitedTime,lowTime,parent,result);
	        }
	    }
	    return result;
	}

	public void dfs(int curr, boolean[] visited, int[] visitedTime, int[] lowTime, int[] parent,List<List<Integer>> result){ 
	visited[curr] =true;
	lowTime[curr] = visitedTime[curr] =time++;
	    for(int adj: graph[curr]){
	        if(!visited[adj]){
	            parent[adj]=curr;
	            dfs(adj, visited,visitedTime,lowTime,parent,result);
	            lowTime[curr]= Math.min(lowTime[curr], lowTime[adj]);
	            if(lowTime[adj]> visitedTime[curr]){
	                
	                result.add(Arrays.asList(curr,adj));
	            }
	        }
	        else if(adj != parent[curr]){
	            lowTime[curr]= Math.min(lowTime[curr], visitedTime[adj]);
	        }
	    }                                                               
	    
	}
	
}
