package com.leetcode;

import java.util.Arrays;

public class RedundantConnectionII {
	public static void main(String[] args) {
		RedundantConnectionII r=new RedundantConnectionII();
		int edges[][]= {{6,3},{8,4},{9,6},{3,2},{5,10},{10,7},{2,1},{7,6},{4,5},{1,8}};
		r.findRedundantDirectedConnection(edges);
	}
	 public int[] findRedundantDirectedConnection(int[][] edges) {
         
	        // We need to ensure that each node has only one parent 
	        // and there are no cycle in this directed graph
	         
	        int []map = new int[edges.length + 1] ;
	         
	         int ans1[] = null ; //first edge
	         int ans2[] = null ; //current edge
	         
	        for(int[] edge : edges) {
	            int u = edge[0] ;
	            int v = edge[1] ;
	            
	            if(map[v] > 0) { //[2,3] -> [1,3] / [2,3]
	                ans1 = new int[] {map[v], v} ;
	                ans2 = edge ;
	            }
	            
	            map[v] = u ;
	        } 
	         
	         
	         
	        int[] parent = new int[edges.length + 1] ;
	          
	         for(int[] edge : edges) {
	             
	             if(edge == ans2) continue ;
	             
	             int u = edge[0] ;
	             int v = edge[1] ;
	             
	             int pu = findParent(u, parent) ;
	             int pv = findParent(v, parent) ;
	             
	             if(pu == pv) { // if cycle
	                 return ans1 == null ? edge :ans1 ;
	             }
	             
	             parent[pv] = u ; //union/collapse
	        }
	          
	        return ans2 ;
	     }
	 int findParent(int v, int[]parent) {
	        if(parent[v] == 0) {
	            parent[v] = v ;
	        }
	        
	        if(parent[v] != v) {
	            parent[v] = findParent(parent[v], parent) ;
	        }
	        
	        return parent[v]; 
	    }
}
