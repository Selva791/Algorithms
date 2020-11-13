package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSubsetII {
	public static void main(String[] args) {
		UniqueSubsetII u=new UniqueSubsetII();
		int nums[]= {4,4,4,1,4};
		u.subsetsWithDup(nums);
	}
	   List<List<Integer>> res;
	    public List<List<Integer>> subsetsWithDup(int[] nums) {
	    	Arrays.sort(nums);
	        res=new ArrayList<>();
	        helper(nums,nums.length,new ArrayList<>(),0);
	        System.out.println(res);
	        return res;

	        
	    }
	    public void helper(int[] nums,int n,List<Integer> out,int start){
	    	List<Integer> fix=new ArrayList<>(out);
	        if(n<start){
	           return ; 
	        }
	         
	         if(!res.contains(fix))
	            res.add(fix);
	        
	        for(int i=start;i<n;i++){
	        	if(i>start&&nums[i]==nums[i-1]) {
	        		continue;
	        	}
	            out.add(nums[i]);
	            helper(nums,n,out,i+1);
	            out.remove(out.size()-1);
	            
	            
	        }
	      
	        
	    }
}
