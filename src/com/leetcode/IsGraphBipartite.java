package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IsGraphBipartite {
	public static void main(String[] args) {
		IsGraphBipartite i=new IsGraphBipartite();
		int val[][]= {{1,3},{0,2},{1,3},{0,2}};
		System.out.println(i.isBipartite(val));
	}
	 List<Integer> graph[];
	    public boolean isBipartite(int[][] val) {
	        int n=val.length;
	        graph=new ArrayList[n];
	        for(int i=0;i<n;i++){
	            List<Integer> value=new ArrayList<>();
	            graph[i]=value;
	        }
	        for(int i=0;i<n;i++){
	            for(int a:val[i]){
	                graph[i].add(a);
	               // graph[a].add(i);
	            }
	        }
	        int count[]=new int[n];
	        count[0]=-1;
	       for(int i=0;i<n;i++) {
            if(count[i]==0){
                count[i]=-1;
               if(!biPartite(i,count,-1)) {
	        		return false;
	        	 } 
            }
	        	
	        }
	        return true;
	    }
	    public boolean biPartite(int s,int count[],int p){
	            
	       
	        for(int v:graph[s]){
	            if(v==p)continue;
	            
	            if(count[s]==-1&&count[v]==0){
	               count[v]=-2;
	                if(!biPartite(v,count,s))return false;
	            }else if(count[s]==-2&&count[v]==0){
	                 count[v]=-1;
	                if(!biPartite(v,count,s))return false;
	            }else if(count[s]!=count[v]){
	               return true;
	            }else{
	                return false;
	            }
	            
	        }
	        return true;
	    }
}
