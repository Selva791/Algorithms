package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfLongestIncreasingSubsequence {
	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequence n = new NumberOfLongestIncreasingSubsequence();
		int nums[] = { 1,1,1,2,2,2,3,3,3 };
		System.out.println(n.findNumberOfLIS(nums));
	}

	 public int findNumberOfLIS(int[] nums) {
	       int n=nums.length;
	       int dp[]=new int [n];
	       int count[]=new int [n];

	       Arrays.fill(dp,1);
	       Arrays.fill(count,1);

	       for(int i=1;i<n;i++) {
	    	   for(int j=0;j<i;j++) {
	    		   if(nums[i]>nums[j]) {
	    			   if(dp[j]+1>dp[i]) {
	    				   dp[i]=1+dp[j];
	    				//   count[i]=count[j];
	    			   }else if(dp[j]+1==dp[i]) {
	    				  
	    				   count[i]+=count[j];
	    			   }
	    		   }
	    	   }
	       }
	        
	        return 0;
	    }
	    
	    public int helper(int[] a, int l, int i, int[] dp, Map<String, Integer> map) {
	        if(l == 1)
	            return 1;
	        String key = l + "->" + i;
	        if(map.containsKey(key))
	            return map.get(key);
	        int count = 0;
	        for (int j = 0; j < i; j++)
	            if (a[i] > a[j] && dp[j] == l - 1)
	                count += helper(a, l-1, j, dp, map);
	        map.put(key, count);
	        return map.get(key);
	    }
}
