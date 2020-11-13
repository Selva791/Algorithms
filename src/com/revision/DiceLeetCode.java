package com.revision;

public class DiceLeetCode {
	public static void main(String[] args) {
		//no of dice, faces, sum and 10^0+7 for over flow
		 System.out.println(numRollsToTarget(30, 30, 500));  
	       System.out.println(numRollsToTarget(2, 2, 3));  
	        System.out.println(numRollsToTarget(3, 6, 8));  
	        System.out.println(numRollsToTarget(2, 4, 5));  
	        System.out.println(numRollsToTarget(3, 4, 5));  
	}
	    public static int numRollsToTarget(int d, int f, int target) {
	        if( d * f < target) {
	            return 0;
	        }

	        int[][] dp = new int[d+1][target+1];

	        dp[0][0] = 1; // initial state

	       for(int i=1;i<=d; i++) {
	            for(int j=1;j<=target;j++) {
	                for(int k=1;k<=f && k <=j;k++) {
	                    dp[i][j] = (dp[i][j] + dp[i-1][j - k]) % 1000000007;
	                }
	            }
	        }
	        return dp[d][target];
	}
	}