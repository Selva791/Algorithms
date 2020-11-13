package com.leetcode;

import java.util.Arrays;

public class GraphShortestPathToAllNodes {
	public static void main(String[] args) {
		int g[][]={{1,2,3},{0},{0},{0}};
		GraphShortestPathToAllNodes gt=new GraphShortestPathToAllNodes();
		System.out.println(gt.shortestPathLength(g));
	}
	  public int dfs(int start, boolean[] visit, int depth){
	        if(visit[start]) return 0;
	        visit[start] = true;
	        int result = depth;
	        for(int to : graph[start]){
	            result = Math.max(result, dfs(to, visit, depth+1));
	            if(result == N-1)return N-1;
	        }
	        visit[start]=false;
	        return result;
	    }
	    int[][] graph;
	    int N;
	    public int shortestPathLength(int[][] graph) {
	        this.graph = graph;
	        this.N = graph.length;
	        int result = 0;
	        for(int i = 0; i < N; i++){
	            result = Math.max(result, dfs(i, new boolean[N], 0));
	            if(result == N-1)return N-1;
	        }
	        return 2*N-2-result;
	    }
	}

