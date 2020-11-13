package com.leetcode;
//DP
public class MinimumCostTreeFromLeafValues {
public static void main(String[] args) {
	MinimumCostTreeFromLeafValues m=new MinimumCostTreeFromLeafValues();
	int arr[]= {6,2,4};
	System.out.println(m.mctFromLeafValues(arr));
	
}
public int mctFromLeafValues(int[] arr) {
    int length = arr.length;
    
    int[][] maxs = new int[length][length];
    int[][] dp = new int[length][length];
    
    //maxs[i][j] represent the maximum number in arr[i:j]
    for(int i = 0;i<length;i++){
        maxs[i][i] = arr[i];
        for(int j = i+1; j<length;j++){
            maxs[i][j] = Math.max(maxs[i][j-1], arr[j]);
        }
    }
    
    //dp[i][j] represent the minimum cost in arr[i:j] 
    for(int len = 1; len<length; len++){
        for(int i = 0; i+len < length; i++){
            int j = i+len;
            dp[i][j] = Integer.MAX_VALUE;
            for(int k= i; k<j ; k++){
                dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + maxs[i][k] * maxs[k+1][j]);
            }
        }
    }
    return dp[0][length-1];
}
}
