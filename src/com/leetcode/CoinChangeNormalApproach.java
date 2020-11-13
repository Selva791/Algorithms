package com.leetcode;

import java.util.Arrays;

public class CoinChangeNormalApproach {
	public static void main(String[] args) {
		int coins[]= {1};
		//[186,419,83,408]
			//	6249
				// {1,2,5};
		int a=2;
		CoinChangeNormalApproach c=new CoinChangeNormalApproach();
		System.out.println(c.coinChange(coins, a));
	}
	 public int coinChange(int[] coins, int amount) {
         int n=coins.length;
        if(amount==0)return 0;
        if(n==1&&coins[0]==amount) {
        	return 1;
        }
      //  Arrays.sort(coins);
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<amount+1;i++) {
        	dp[0][i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n+1;i++) {
        	dp[i][0]=0;
        }
      for(int i=1;i<=n;i++){
          for(int j=1;j<=amount;j++){
        	  
              if(j>=coins[i-1]&&dp[i][j-coins[i-1]]!=Integer.MAX_VALUE) {
            	  dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
              }else {
            	  dp[i][j]=dp[i-1][j];
              }
              
          }
          
      }
   
           return  dp[n-1][amount]==Integer.MAX_VALUE?-1:dp[n][amount];
 }
	 /* public int coinChange(int[] coins, int amount) {
          int n=coins.length;
   if(n==1&&coins[0]==amount)return 1;
 
      int dp[][]=new int[n][amount+1];
    for(int i=0;i<n;i++){
          for(int j=1;j<amount+1;j++){
              
              if(i==0&&coins[i]<=j){
                  int c=dp[i][j-coins[i]];
                  dp[i][j]=1+c;

              }else if(i>0&&coins[i]<=j){
                    int c=dp[i][j-coins[i]];
                 int r=Math.min(1+c,dp[i-1][j]);
                  dp[i][j]=r;
              }
              else if(i>0){
                  dp[i][j]=dp[i-1][j];
              }
          }
      }
    
      return dp[n-1][amount]==0?-1: dp[n-1][amount];
  
  }*/

}
