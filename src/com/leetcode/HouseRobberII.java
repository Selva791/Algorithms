package com.leetcode;

public class HouseRobberII {
	public static void main(String[] args) {
		HouseRobberII hr=new HouseRobberII();
		int nums[]= {1,3,1,3,100};
		int start=0;
		int n=0;
		System.out.println(hr.rob(nums));
		
	}
	public int rob(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        if(n==1) return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);

       int a= looter(nums,0,n-1);
        int b=looter(nums,1,n);
        return Math.max(a,b);
       
    }
    public int looter(int nums[],int start,int n){
          int dp[]=new int[nums.length-1];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
        for(int i=2+start;i<n;i++){
          dp[i-start]=Math.max(nums[i]+dp[i-start-2],dp[i-start-1]);
           
            
        }
           return dp[nums.length-2];
    }
}
