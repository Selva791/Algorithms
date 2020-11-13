package com.leetcode;

public class UncrossedLines {
	public static void main(String[] args) {
		UncrossedLines un=new UncrossedLines();
		//[3,3,2]
				//[3,3,1,2]
		int A[]= {3,3,2};
				//{2,5,1,2,5};
		int B[]= {3,3,1,2};
		//{10,5,2,1,5,2};
		System.out.println(un.maxUncrossedLines(A, B));
	}
	public int maxUncrossedLines(int[] A, int[] B) {
		int dp[][]=new int[A.length+1][B.length+1];
		for(int i=1;i<=A.length;i++) {
			for(int j=1;j<=B.length;j++) {
				if(A[i-1]==B[j-1]) {
					dp[i][j]=1+dp[i-1][j-1];
					
				}else {
					dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
				}
				
			}
		}
		return dp[A.length][B.length];
	}
}
