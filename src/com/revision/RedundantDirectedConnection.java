package com.revision;

import java.util.ArrayList;
import java.util.List;

public class RedundantDirectedConnection {
	  public static void main(String[] args) {
		  RedundantDirectedConnection r=new RedundantDirectedConnection();
      	int edges[][]= {{1,2}, {1,3}, {2,3}}; 
      			//{{1,2}, {2,3}, {3,4}, {4,1}, {1,5},{4,5}};
      	r.findRedundantDirectedConnection(edges);
		}
	  List<Integer> graph[];
	    int pair[] ={-1,-1};
	    int count[];
	    int one=-1;
	    int two=-1;
	    int mat[][];
	    int last=-1;
	    public int[] findRedundantDirectedConnection(int[][] edges) {
	    	one=-1;
	    	two=-1;
	        int n=edges.length;
	    	mat=new int[n+1][n+1];

	        count=new int[n+1];
	        graph=new ArrayList[n+1];
	        for(int i=0;i<n+1;i++){
	            graph[i]=new ArrayList<>();
	            
	        }
	        int h=0;
	        for(int i=0;i<n;i++){
	            int temp[]=edges[i];
	            graph[temp[0]].add(temp[1]);
	            mat[temp[0]][temp[1]]=h++;
	            count[temp[1]]++;
	            if(count[temp[1]]>1) {
	            	one=temp[0];
	            	two=temp[1];
	            	
	            	
	            }
	        }
	        boolean visited[]=new boolean[n+1];
	        boolean check[]=new boolean[n+1];
	        
	        for(int i=1;i<=n;i++) {
	        	 if(helper(i,visited,check))break;
	        }
	        if(pair[0]==-1) {
	        	 pair[0]=one;
	        	 pair[1]=two;
	        	 return pair;
	        	
	        }
	        return pair;
	    }
	    public boolean helper(int start,boolean visited[], boolean check[]){
	    	if(check[start]) {
	    		return true;
	    	}
	    	if(visited[start]) {
	    		return false;
	    	}
	    	visited[start]=true;
	    	check[start]=true;
	        List<Integer>t=graph[start];
	        visited[start]=true;
	        
	        for(int s:t){
	           
	            if(helper(s,visited,check)) {
	            	if(two!=-1) {
                        if(two==s&&pair[0]==-1){
                          pair[0]=start;
		   	              pair[1]=s;  
                        }
	            		
	            	}else if(mat[start][s]>last&&pair[0]==-1){
	            		last=mat[start][s];
                        pair[0]=start;
		   	            pair[1]=s;
                    }
	                 	
	                 
	                }
	            return true;
	             
	            }
	        check[start]=false;
	        return false;
	        }
	    }


