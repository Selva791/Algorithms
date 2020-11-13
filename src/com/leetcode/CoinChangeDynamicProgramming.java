package com.leetcode;

public class CoinChangeDynamicProgramming {

	public static void main(String[] args) {
		CoinChangeDynamicProgramming cp=new CoinChangeDynamicProgramming();
			
		cp.change(5, new int[]{1,2,5});
	}
	 public int change(int amount, int[] coins) {
	        int n=coins.length;
	        int dp[][]=new int[n+1][amount+1];
	        for(int i=0;i<=n;i++){
	            for(int j=0;j<=amount;j++){
	                if(j==0){
	                    dp[i][j]=1;
	                    
	                }else if(j>0&&i>0){
	                    int p=0;
	                    if(j>=coins[i-1]){
	                       p=j-coins[i-1];
	                         dp[i][j]=dp[i][p]+dp[i-1][j];

	                    }else{
	                         dp[i][j]=dp[i-1][j];
	                    }
	                        
	                        
	                }
	                
	            }
	            
	            
	        }
	        return dp[n][amount];
	    }
}
