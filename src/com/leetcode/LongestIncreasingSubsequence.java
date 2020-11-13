package com.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		LongestIncreasingSubsequence ls=new LongestIncreasingSubsequence();
		int nums[]= {1,3,6,7,9,4,10,5,6}; 
			//{10,9,2,5,3,7,101,18};
		System.out.println(ls.lengthOfLIS(nums));
	}
	 public int lengthOfLIS(int[] nums) {
		   int n=nums.length;

	        if(n==0)return 0;
		        int dp[]=new int[n];  
		        int count=0;
		        Arrays.fill(dp,1);
		        for(int i=1;i<n;i++){
		            int max=nums[i];
		            for(int j=0;j<i;j++){
		                
		                if(max>nums[j]){
		                    dp[i]=Math.max(dp[i],dp[j]+1);
		                    
		                }

		            }
		           
		            
		        }
		        return Arrays.stream(dp).max().getAsInt();
	    }
}
