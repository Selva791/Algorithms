package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationII {
	public static void main(String[] args) {
		PermutationII p=new PermutationII();
		int nums[]= {1,2,3};
		p.permuteUnique(nums);
	}
	 List<List<Integer>> result;
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        int n =nums.length;
	        result=new ArrayList<>();
	        boolean used[]=new boolean[n];
	        findCombinations(nums,0,new ArrayList<>(),used);
	        return result;
	    }
	    
	    public void findCombinations(int nums[],int start,List<Integer> values,boolean used[]){
	        if(values.size()==nums.length){
	        	if(!result.contains(values))
	        		result.add(new ArrayList<>(values));
	        	
	            return;
	        }
	        for(int i=0;i<nums.length;i++) {
	        	if(used[i])
	        	  continue;
	        	
	        	used[i]=true;
	        	values.add(nums[i]);
	        	findCombinations(nums, start, values,used);
	        	used[i]=false;
	        	values.remove(values.size()-1);
	        }
	        return;
	    }
}




