package com.leetcode;

public class BestTimetoBuyAndSellStockIIITry {
	public static void main(String[] args) {
		//[2,4,1], k = 2
		BestTimetoBuyAndSellStockIIITry b=new BestTimetoBuyAndSellStockIIITry();
		int p[]= {2,4,1};
		b.maxProfit(2,p);
	}

	
	 public int maxProfit(int k, int[] prices) {
	        int n=prices.length;
	        int dp[][]=new int[k+1][n];
	        int temp=0;
	        for(int i=1;i<k;i++){
	            for(int j=1;j<n;j++){
	            	dp[i][j] =prices[j]-prices[i-1];
	                for(int t=1;t<j;t++){
	                    int s=dp[i][t]+dp[t][j];
	                  dp[i][j] = Math.max(s,dp[i][j]);
	                    
	                }
	                
	            }
	            
	        }
	        return dp[k][n-1];
	    }
}
