package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
	public static void main(String[] args) {
		int g[][]= {{1,2},{3},{3}, {}} ;
		AllPathsFromSourcetoTarget a=new AllPathsFromSourcetoTarget();
		a.allPathsSourceTarget(g);
	}
    List<Integer>[] adj;
    List<List<Integer>> result;

public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int n=graph.length;
    adj=new ArrayList[n];
    result=new ArrayList<>();
    for(int i=0;i<n;i++){
        adj[i]=new ArrayList<>();
                    
    }
    for(int i=0;i<n;i++){
        int s[]=graph[i];
        for(int g:s){
            adj[i].add(g);
            
        }
        
    }
    helper(0,n-1,new ArrayList<>());
    return result;
}
public void helper(int v,int n,List<Integer> cur){
    List<Integer> value=adj[v];
        cur.add(v);
    if(v==n){
       result.add(new ArrayList<>(cur)); 
    }

    for(int b:value){
        helper(b,n,cur);
        cur.remove(cur.size()-1);
    }
        
    
}
}
