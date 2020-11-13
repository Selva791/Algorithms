package com.leetcode;

import java.util.TreeMap;

public class BOatsToSavePeople {

	public static void main(String[] args) {
		BOatsToSavePeople b=new BOatsToSavePeople();
		int people[]= {21,40,16,24,30};
				
		int limit=50;
		b.numRescueBoats(people, limit);
		
	}
	 public int numRescueBoats(int[] people, int limit) {
	        int n=people.length;
	        TreeMap<Integer,Integer> mp=new TreeMap<>();
	        int count=0;
	        for(int i=0;i<n;i++){
	            if(mp.ceilingKey(people[i])!=null){
	                 int value=mp.ceilingKey(people[i]);
	                 
	                int temp=value-people[i];
	                if(temp==0){
	                	int v=mp.get(value)-1;
	                	if(v>0) {
	                		mp.put(value, v);
	                	}
	                	else {
	                		mp.remove(value);
	                	}
	                }else{
	                	int v=mp.get(value)-1;
	                	if(v>0)mp.put(value, v);
	                	else mp.remove(value);
	                	
	                	
	                	
	                     mp.put(temp,mp.getOrDefault(temp,0)+1);
	                }
	                
	            }else {
	            	   int key=limit-people[i];
	    	           
	   	            if(key==0){
	   	                count+=1;
	   	                continue;
	   	            }
	   	            count+=1;
	   	            mp.put(key,mp.getOrDefault(key,0)+1);
	            }
	            
	         
	        }
	        return count;
	    }
}
