package com.leetcode;

public class BestTimetoBuyAndSellStockIII {
	public static void main(String[] args) {
		int p[]= {1,2,3,4,5}; 
			//{3,3,5,0,0,3,1,4};
			//{7,6,4,3,1};
			//{3,3,5,0,0,3,1,4};
		BestTimetoBuyAndSellStockIII b=new BestTimetoBuyAndSellStockIII();
		b.maxProfit(p);
	}
	
	 public int maxProfit(int[] prices) {
	        int n=prices.length;
	      int dp[][]=new int[3][n];
	        for(int i=1;i<3;i++){
	            int maxDiff=-prices[0];
	            for(int j=1;j<n;j++){
	                dp[i][j]=Math.max(dp[i][j-1],maxDiff+prices[j]);
	            	maxDiff=Math.max(maxDiff,dp[i-1][j-1]-prices[j]);
	  
	            }
	            
	        }
	        return dp[2][n-1];
	    }

}
