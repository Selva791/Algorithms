package com.leetcode;

public class MinimumCostTreeFromLeafValuesDynamicProgramming {
	public static void main(String[] args) {
		MinimumCostTreeFromLeafValuesDynamicProgramming m=new MinimumCostTreeFromLeafValuesDynamicProgramming();
		int arr[]= {6,2,4};
		System.out.println(m.mctFromLeafValues(arr));
	}
	 public int mctFromLeafValues(int[] arr) {
	        int n=arr.length;
	        int max[][]=new int[n][n];
	            int dp[][]=new int[n][n];
	            for(int i=0;i<n;i++){
	                max[i][i]=arr[i];
	                
	            }
	            for(int k=1;k<=n-1;k++){
	                for(int i=0;i<n-k;i++){
	                    int j=i+k;
	                  max[i][j]= Math.max(max[i][j-1],max[i+1][j]);
	                }
	            }
	        for(int len=1;len<=n-1;len++){
	            for(int i=0;i<n-len;i++){
	                int j=i+len;
	                	dp[i][j]=Integer.MAX_VALUE;
	                      for(int k=i;k<j;k++){
	                         dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+(max[i][k]*max[k+1][j])); 
	                    
	                }
	                
	                
	              
	            }
	        }
	        return dp[0][n-1];
	    }

}
