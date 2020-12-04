package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem  {
	public static void main(String[] args) {
		int buildings[][]= {{2 ,9, 10}, {3, 7, 15}, {5 ,12 ,12}, {15 ,20, 10}, {19 ,24 ,8}};
		TheSkylineProblem sky=new TheSkylineProblem();
		System.out.println(sky.getSkyline(buildings));
	}
	 public List<List<Integer>> getSkyline(int[][] buildings) {
	        int n=buildings.length; 
	        
	        List<List<Integer>> res=new ArrayList();
	         if(n==0){
	            return res;
	        }
	        int m=buildings[0].length;
	        
	        List<int[]> value=new ArrayList();
	        
	       for(int i=0;i<n;i++){
	          int b[]= buildings[i];
	        value.add(new int[]{b[0],-b[2]});
	           value.add(new int[]{b[1],b[2]});
	           
	       }
	        Collections.sort(value,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
	            
	        Queue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
	        pq.offer(0);
	        int prev=0;
	           for(int a[]:value){
	               if(a[1]<0){
	                   pq.offer(-a[1]);
	               }else {
	                    pq.remove(a[1]);
	               }
	               int c=pq.peek();
	               if(c!=prev){
	                   prev=c;
	                   res.add(Arrays.asList(a[0],c));
	               }
	               
	           }            
	        
	        return res;
	        
	    }
	    
}
