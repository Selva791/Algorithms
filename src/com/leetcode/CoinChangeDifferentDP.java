package com.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChangeDifferentDP {
	public static void main(String[] args) {
		CoinChangeDifferentDP dp=new CoinChangeDifferentDP();
		System.out.println(dp.coinChange(new int[] {2,5,10,1}, 27));
	}
	public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[]=new int[amount+1];
         int result[]=new int[amount+1];
        Arrays.fill(result,-1);
        Arrays.fill(dp,200000);
        dp[0]=0;
        result[0]=0;
        for(int i=0;i<n;i++){
             int c=coins[i];

            for(int j=1;j<=amount;j++){
            if(j>=c){
            
           dp[j]= Math.min(dp[j],1+dp[j-c]);
                result[j]=i;
              
            }
           
                
            }
            
        }
        if(dp[amount]==Integer.MIN_VALUE||dp[amount]==Integer.MAX_VALUE) {
        	dp[amount]=-1;
        }
        return dp[amount];
    }
}
