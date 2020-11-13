package com.leetcode;

public class LongestIncreasingPathInaMatrix {
	public static void main(String[] args) {
		LongestIncreasingPathInaMatrix l=new LongestIncreasingPathInaMatrix();
		
		int matrix[][]= {{3,4,5},{3,2,6},{2,2,1}};
		System.out.println(l.longestIncreasingPath(matrix));
		
	}
	 public int longestIncreasingPath(int[][] matrix) {
	        
	        int n=matrix.length;
	        int m=matrix[0].length;
	        int dp[][]=new int[n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                
	                helper(matrix,i,j,dp,matrix[i][j]);
	            }
	            
	        }
	        return max;
	    }
	    int max=0;
	    public int helper(int[][] matrix,int i,int j,int dp[][],int value){
	        
	        if(i<0||j<0||i>=matrix.length||j>=matrix[0].length){
	            return 0;
	        }
	        int c1=1,c2 = 1,c3=1,c4=1;
	        if(dp[i][j]>0)return dp[i][j];
	        
	            if((i+1<matrix.length)&&matrix[i+1][j]>value)
	               c1+= helper(matrix,i+1,j,dp,matrix[i+1][j]);
	                
	           if((j+1<matrix[0].length)&&matrix[i][j+1]>value)
	               c2+=helper(matrix,i,j+1,dp,matrix[i][j+1]);
	               
	            if((i-1>=0)&&matrix[i-1][j]>value)
	                c3+=helper(matrix,i-1,j,dp,matrix[i-1][j]);
	        
	            if((j-1>=0)&&matrix[i][j-1]>value)
	                c4+=helper(matrix,i,j-1,dp,matrix[i][j-1]);
	                   
	          int r= Math.max(c1, Math.max(c2, Math.max(c3, c4)));
	          dp[i][j]=r;
	            if(max<r)max=r;
	        return r ;
	        
	    }
}
