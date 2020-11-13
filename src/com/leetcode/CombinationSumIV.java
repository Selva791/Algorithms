package com.leetcode;

import java.util.Arrays;

public class CombinationSumIV {
	public static void main(String[] args) {
		CombinationSumIV c=new CombinationSumIV();
		int nums[]= {1,2,3};
		int target=4;
		System.out.println(c.combinationSum4(nums, target));
	}
	
	public int combinationSum4(int[] nums, int target) {
        int n= nums.length;
        int dp[]=new int[target+1];
        Arrays.fill(dp,-1);
        return combination(nums,0,target,dp);
    }
    
    public int combination(int[] nums,int start,int target,int dp[]){
        if(dp[target]!=-1){
            return dp[target];
        }
    	if(target==0){
    		return 1;
    	}
        if(start>=nums.length){
            return 0;
        }
        int c=0;
        for (int i=0;i<nums.length;i++) {
        	if(target-nums[i]>=0) {
        		c+=combination(nums,i,target-nums[i],dp);
        	}
        }
         dp[target]=c;
        return c;
    }

}
