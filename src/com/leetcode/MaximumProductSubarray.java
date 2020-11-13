package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		MaximumProductSubarray m=new MaximumProductSubarray();
		int nums[]= {2,-1,1,1};
		System.out.println(m.maxProduct(nums));
	}
	public int maxProduct(int[] nums) {
		 int n=nums.length;
	        if(n==1){
	            return nums[0];
	            
	        }
	        int max=nums[0];
	        int min=nums[0];
	        int result=0;
	        for(int i=1;i<n;i++){
	            int temp=max;
	            max=Math.max(nums[i],Math.max(max*nums[i],min*nums[i]));
	            min=Math.min(nums[i],Math.min(temp*nums[i],min*nums[i]));
	           // max=Math.max(max,min);
	           result=Math.max(result,max);
	        }
	        
	        return result;
	       
    }
}
