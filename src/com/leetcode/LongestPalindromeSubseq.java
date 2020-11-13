package com.leetcode;

public class LongestPalindromeSubseq {
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
	}
	 public static  int longestPalindromeSubseq(String s) {
	       
	        int n=s.length();
	        int dp[][]=new int[n][n];
	   
	        for(int i=1;i<=n;i++){
	            for(int j=0;i+j<=n;j++){
	                int k=j+i-1;
	               
	             if(j==k) {
	            	 dp[j][k]=1; 
	             }else if(s.charAt(j)==s.charAt(k)){
	            	 dp[j][k]=dp[j+1][k-1]+2;
	             }else {
	            	 dp[j][k]=Math.max(dp[j][k-1],dp[j+1][k]);

	            	 
	             }
	                
	                
	            }
	            
	        }
	        
	        return dp[0][n-1];
	    
	    }
}
