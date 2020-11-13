package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphCourseScheduled {
	public static void main(String[] args) {
		GraphCourseScheduled graph=new GraphCourseScheduled();
		int pr[][]= {{1,0},{2,0}};
		System.out.println(graph.canFinish(3, pr));
	}
	  LinkedList<Integer> adj[];
	    
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        
	        adj=new LinkedList[numCourses];
	        for(int i=0;i<numCourses;i++){
	            adj[i]=new LinkedList<>();
	        }
	        for(int i=0;i<prerequisites.length;i++){
	              int k[]=prerequisites[i];
	            int u=k[0];
	            int v=k[1];
	            adj[u].add(v);
	                
	        }
	        boolean visit[]=new boolean[numCourses];
	        boolean restack[]=new boolean[numCourses];

	        Stack<Integer> top=new Stack<>();
	        for(int i=0;i<numCourses;i++){
	              if(!finisher(i,top,visit,restack)) {
	            	  
	            	  return false;
	            	  
	              }
	            }
	            
	        return true;
	    }
	    public boolean finisher(int d, Stack<Integer> top,boolean visit[],boolean restack[]){
	    
	        LinkedList<Integer> check=adj[d];
	        if(restack[d]) {
	        	return false;
	        	
	        }
	        if(visit[d]) {
	        	return true;
	        	
	        }
	        restack[d]=true;
	        visit[d]=true;
	        if(!check.isEmpty()){
	    		visit[d]=true;

	           Iterator<Integer> itr=check.iterator(); 
	            while(itr.hasNext()){
	                int v=itr.next();
	                 if(!finisher(v,top,visit,restack)) return false;
	                     
	                
	            }
	           
	        }
	        restack[d]=false;
	        top.push(d);
	        return true;
	    }

}
