package com.leetcode;

public class MaximalSquareDynamicProgramming {
public static void main(String[] args) {
	MaximalSquareDynamicProgramming md=new MaximalSquareDynamicProgramming();
	char mat[][]= {{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'}};
	System.out.println(md.maximalSquare(mat));
}
public int maximalSquare(char[][] matrix) {
    int n=matrix.length;
    if(n==0) return 0;
   
    int m=matrix[0].length;
    int mat[][]=new int [n][m];
    int dp[][]=new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            mat[i][j]=matrix[i][j]-'0';
            
        }
    }
     if(n==1&&mat[0][0]==1) return 1;
    
    for(int i=0;i<n;i++){
        dp[i][0]=mat[i][0];
    }
      for(int i=0;i<m;i++){
        dp[0][i]=mat[0][i];

    }
    
    for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){
            if(mat[i][j]==1){
                dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
            }else{
               dp[i][j]=0; 
            }
        }
    }
    int value=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++ ){
            if(value<dp[i][j]){
                value=dp[i][j];
                
            }
        }
        
    }
    return value*value;
}
public int min(int x,int y,int z){
    
    int a=x>y?y:x;
    int b=a>z?z:a;
        return b;
}
}
