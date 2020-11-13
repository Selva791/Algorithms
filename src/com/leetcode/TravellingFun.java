package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravellingFun {
	public static void main(String[] args) {
		TravellingFun t=new TravellingFun();
		List<Integer> originCities=new ArrayList<>();
		List<Integer> destinationCities=new ArrayList<>();
		originCities.add(1);
		originCities.add(2);
		originCities.add(4);
		originCities.add(6);
		destinationCities.add(3);
		destinationCities.add(3);
		destinationCities.add(3);
		destinationCities.add(4);
		t.connectedCities(6, 1, originCities, destinationCities);
	}

	public static int connection(int a,int b){
        
	     
	      if (b == 0) 
	        return a; 
	      return connection(b, a % b);  
	     
	    }
	    public static int  find(int arr[],int a){
	        if(arr[a]<0){
	            return a;
	        }
	        return find(arr,arr[a]);
	    }
	    public static List<Integer> connectedCities(int numCities, int threshold,  List<Integer> originCities, List<Integer> destinationCities) {
	    // Write your code here
	        List<Integer> result=new ArrayList<>();
	        int union[]=new int[numCities+1];
	        Arrays.fill(union,-1);
	        int n=originCities.size();
	        for(int i=0;i<n;i++){
	            int r=connection(originCities.get(i),destinationCities.get(i));
	            if(r>=threshold){
	                result.add(1);
	                if(originCities.get(i)>destinationCities.get(i))
	                    union[originCities.get(i)]=destinationCities.get(i);
	                else union[destinationCities.get(i)]=originCities.get(i);
	             
	            }
	            else{
	                   
	                int a=find(union,originCities.get(i));
	                int b=find(union,destinationCities.get(i));
	                if(a==b){
	                    result.add(1);
	                }else if(a!=b){
	                    result.add(0);
	                }
	                
	            } 
	        }
	    return result;
	    }

}
