package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps {
	public static void main(String[] args) {
		SmallestStringWithSwaps s = new SmallestStringWithSwaps();
		 List<List<Integer>> pairs=new ArrayList<>();
		 pairs.add(Arrays.asList(0,3));
		 pairs.add(Arrays.asList(1,2));
		 pairs.add(Arrays.asList(0,2));
		 //pairs.add(Arrays.asList(a));
		 String st="dcab";
		System.out.println(s.smallestStringWithSwaps(st, pairs));
	}

	 public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
	        int n=pairs.size();
	        int m=s.length();
	        int values[]=new int [m];
	        Arrays.fill(values,-1);
	        char [] arr=s.toCharArray();
	        for(int i=0;i<n;i++){
	            int a=pairs.get(i).get(0);
	            int b=pairs.get(i).get(1);
	            
	            int c=union(values,a);
	            int d=union(values,b);
	            if(c!=d){
	                find(c,d,values);
	            }
	                
	            
	        }
	        
	    Map<Integer,PriorityQueue<Character>> mp=new HashMap<>();
	        for(int i=0;i<m;i++){
	            int root=union(values,i);
	            mp.putIfAbsent(root,new PriorityQueue<>());
	            mp.get(root).add(arr[i]);
	        }
	        StringBuilder sb=new StringBuilder();
	    for(int i=0;i<m;i++){
	        sb.append(mp.get(union(values,i)).poll());
	    }
	        return sb.toString();
	    }
	    
	    public int union(int values[],int a){
	    	
	        if(values[a]<0){
	            return a;
	        }
	        return union(values,values[a]);
	    }
	    public void find(int a,int b,int values[]){
	        
	       if(a>b){
	         values[a]=b;
	       }else{
	          values[b]=a;
	       }
	    }
}
