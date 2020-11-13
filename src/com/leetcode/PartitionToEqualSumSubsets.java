package com.leetcode;

import java.util.Arrays;

public class PartitionToEqualSumSubsets {
	public static void main(String[] args) {
		PartitionToEqualSumSubsets pat=new PartitionToEqualSumSubsets();
		int nums[]= {2,2,2};
		int k=3;
		System.out.println(pat.canPartitionKSubsets(nums, k));
	}
	public boolean canPartitionKSubsets(int[] nums, int k) {
		  if(nums.length == 0 || k == 0) {
	            return false;
	        }
	        
        int len=nums.length;
        int s=0;
        for(int a:nums){
            s+=a;
            
        }
        if(s%k!=0){
        return false;
            
        }
        Arrays.sort(nums);
        boolean visited []=new boolean[len];
        return partition(nums,k,s/k,0,visited,0);
        
    }
    public boolean partition(int nums[],int k,int part,int j,boolean [] visited,int sum){
        if(k==0){
            return true;
            
        }
        if(sum>part){
            return false;
            
        }
        if(sum==part){
            return partition(nums,k-1,part,0,visited,0);
            
        }
        
        for(int i=j;i<nums.length;i++){
        	if(!visited[i]){
                visited[i]=true;
               if(partition(nums,k,part,i+1,visited,nums[i]+sum)){
                   return true;
               }
               visited[i]=false;

            }

        }
        return false; 
    }
}
