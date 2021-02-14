package com.leetcode;

public class MatrixBlockSum {
	public static void main(String[] args) {
		MatrixBlockSum m=new MatrixBlockSum();
		int mat[][]= {{1,2,3},{4,5,6},{7,8,9}};
		int k=1;
		System.out.println(m.matrixBlockSum(mat, k));
	}
	  public int[][] matrixBlockSum(int[][] mat, int k) {
	        int n=mat.length, m=mat[0].length;
	        int dp[][]=new int[n+1][m+1];
	        
	        for(int i=1;i<n;i++){
	            for(int j=1;j<m;j++){
	                dp[i][j]=dp[i-1][j]+dp[i][j-1]+mat[i-1][j-1];
	            }
	        }
	        int res[][]=new int[n][m];
	        
	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=m;j++){
	                
	                int r1=i-k<0?0:i-k;
	                int r2=i+k>=n?n-1:i+k;
	                int c1=j-k<0?0:j-k;
	                int c2=j+k>=m?m-1:j+k;
	                int t=0;
	                int p1=0,p2=0;
	                if(r2-1>=0){
	                    p1=dp[r2-1][c1];
	                }
	                if(r1-1>=0){
	                    p2=dp[r1-1][c2];
	                }
	                t+=dp[r2][c2]-(p1+p2);
	                res[i-1][j-1]=t;
	            }
	        }
	        return res;
	    }
}
