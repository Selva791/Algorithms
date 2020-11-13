package com.leetcode;

public class BuySellStockIII {
	public static void main(String[] args) {
		int s[]= {1,2,3,4,5};
		BuySellStockIII b=new BuySellStockIII();
		System.out.println(b.maxProfit(s));
	}
	public int maxProfit(int[] prices) {
        int n=prices.length;
     if(n==0)return 0;
      int dp[][]=new int[3][n];
        for(int i=1;i<3;i++){
            
            for(int j=1;j<n;j++){
                
               for(int k=0;k<j;k++){
                   int a=Math.max(dp[i][j-1],prices[j]-prices[k]+dp[i-1][k]);
                   dp[i][j]=Math.max(dp[i][j],a);
               }
            }
            
        }
        return dp[2][n-1];
    }

}
