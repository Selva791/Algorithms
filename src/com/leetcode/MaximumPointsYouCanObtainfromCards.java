package com.leetcode;

import java.util.Arrays;

public class MaximumPointsYouCanObtainfromCards {
		public static void main(String[] args) {
			MaximumPointsYouCanObtainfromCards m=new MaximumPointsYouCanObtainfromCards();
			int cardPoints[]= {9,7,7,9,7,7,9};
			int k=7;
			System.out.println(m.maxScore(cardPoints, k));
		}
		
		 public int maxScore(int[] cardPoints, int k) {
		        int n=cardPoints.length;
		        int dp[][]=new int[n+1][n+1];
		        for(int d[]:dp) {
		        	 Arrays.fill(d,-1);
		        }
		       
		       return scoreCalc(cardPoints,0,n-1,k,dp);
		    }
		    public int scoreCalc(int[] cardPoints,int start,int end, int k,int dp[][]){
		    	if(start>=cardPoints.length||end<0) {
		    		return 0;
		    	}
		        if(dp[start][end]!=-1){
		            return dp[start][end];
		        }
		        if(k==0){
		            return 0;
		        }
		        int sum=0;
		       sum= Math.max(scoreCalc(cardPoints,start+1,end,k-1,dp)+cardPoints[start],
		        			scoreCalc(cardPoints,start,end-1,k-1,dp)+cardPoints[end]);
		       
		       dp[start][end]=sum;
		        
		        return sum;
		    }
}
