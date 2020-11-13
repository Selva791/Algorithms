package com.leetcode;

public class GuessNumberHigherOrLowerIIDynamicProgramming {
	public static void main(String[] args) {
		GuessNumberHigherOrLowerIIDynamicProgramming d=new GuessNumberHigherOrLowerIIDynamicProgramming();
		System.out.println(d.getMoneyAmount(3));
	}
	 public int getMoneyAmount(int n) {
	        int dp[][]=new int[n+2][n+2];
	        
	        for(int len=2;len<=n;len++){
	            for(int i=1;i<=n-len+1;i++){
	                int j=len+i-1;
	               
		                dp[i][j]=Integer.MAX_VALUE;

	                	 for(int k=i;k<=j;k++){
	                		// System.out.println(i+" "+(k-1)+" "+(k+1)+" "+j);
	                		 System.out.println(k+Math.max(dp[i][k-1],dp[k+1][j]));
	 	                    dp[i][j]=Math.min(dp[i][j],k+Math.max(dp[i][k-1],dp[k+1][j]));
	 	                    
	 	                }
	                	 System.out.println("AND "+dp[i][j]);
	               
	                
	            }
	            
	        }
	            return dp[1][n];

	    }
}
