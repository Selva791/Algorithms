package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum c=new CombinationSum();
		int candidates[]= {2,3,6,7};
		int target=7;
		System.out.println(c.combinationSum(candidates, target));
	}
	 List<List<Integer>> result;
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        result=new ArrayList<>();
	        int n=candidates.length;
	        helper(candidates,n,target,0,new ArrayList<>(),0);
	        return result;
	        
	    }
	   
	    public void helper(int[] candidates,int n, int target,int sum,List<Integer> count,int start){
	        
	        if(sum==target){
	        	
	        		 result.add(new ArrayList<>(count));
	        		 return;
	           
	        }
	        
	        for(int i=start;i<n;i++){
	        	if(sum+candidates[i]<=target){
	                count.add(candidates[i]);
	                helper(candidates,n,target,sum+candidates[i],count,i);
	               
	                count.remove(count.size()-1);
	            
	            }
	            
	        }
	        return;
	    }
}
