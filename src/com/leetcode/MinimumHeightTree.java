package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTree {
	public static void main(String[] args) {
		MinimumHeightTree m=new MinimumHeightTree();
		int edges[][]= {{1,0},{1,2},{1,3}};
		System.out.println(m.findMinHeightTrees(4, edges));
		
	}
	List<List<Integer>> myGraph = new ArrayList<List<Integer>>();
	List<Integer> res = new ArrayList<Integer>();
	private List<Integer> findMinHeightTrees(int n, int[][] edges) {
		// TODO Auto-generated method stub
		//int n=edges.length;
		if (n==1) {
			res.add(0);
			return res;
		}
	    int[] degree = new int[n];
	    for(int i=0; i<n; i++) {
	    	myGraph.add(new ArrayList<Integer>());
	    }
	    for(int i=0; i<edges.length; i++) {
	    	myGraph.get(edges[i][0]).add(edges[i][1]);
	    	myGraph.get(edges[i][1]).add(edges[i][0]);
	    	degree[edges[i][0]]++;
	    	degree[edges[i][1]]++;
	    }
	    Queue<Integer> myQueue = new ArrayDeque<Integer>();
	    
	    for(int i=0; i<n; i++) 
	    	if (degree[i]==0) 
	    		return res;
	    	else if (degree[i]==1) {
	    		myQueue.offer(i);
	    	}
	    
	    while (!myQueue.isEmpty()) {
	    	res = new ArrayList<Integer>();
	    	int count = myQueue.size();
	    	
	    	for(int i=0; i<count; i++){
	    		int curr = myQueue.poll();
	    		res.add(curr);
	    		degree[curr]--;
	    		for(int k=0; k<myGraph.get(curr).size(); k++) {
	    			int next = myGraph.get(curr).get(k);
	    			if (degree[next]==0) continue;
	    			if (degree[next]==2) {
	    				myQueue.offer(next);
	    			}
					degree[next]--;
	    		}
	    	}      	
	    }
	    return res;
	}
	
	/*List<Integer> adj[];
    int height=Integer.MAX_VALUE;
	    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> tr=new ArrayList<>();
            tr.add(0);
            if(n-1==0||n-1<=0)return tr;
	        adj=new ArrayList[n];
	        for(int i=0;i<n;i++){
	            adj[i]=new ArrayList<>();
	        }
	        
	        for(int i=0;i<n-1;i++){
	            adj[edges[i][0]].add(edges[i][1]);
	            adj[edges[i][1]].add(edges[i][0]);

	        }
	        TreeMap<Integer, List<Integer>> result=new TreeMap<>();
	        
	        height=Integer.MAX_VALUE;
	            for(int i=0;i<n;i++){
	            	boolean visited[]=new boolean[n];
	              int temp=helper(i,0,visited,Integer.MIN_VALUE);  
	               
	                if(temp!=0&&temp!=-1){
	                     height=Math.min(temp,height);
	                     List<Integer>t=result.getOrDefault(temp, new ArrayList<>());
	                     t.add(i);
	                     result.put(temp,t);
	                }
	                   
	                
	            }
	           
	            
	        return result.get(height);
	    }
	    public int helper(int n,int h,boolean visited[],int count){
            
	        visited[n]=true;
            if(height!=Integer.MAX_VALUE&&h>height)return -1;
	        if(adj[n].size()>0){
	            for(int s:adj[n]){
	            	
	              if(!visited[s]) {
	            	  count=helper(s,h+1,visited,count);
                      if(count==-1)return -1;
	              }
	            }
	           
	        }
	         count=Math.max(count,h);
	            return count;
	    }*/
}
