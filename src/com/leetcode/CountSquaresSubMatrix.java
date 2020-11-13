package com.leetcode;

public class CountSquaresSubMatrix {
	public static void main(String[] args) {
		CountSquaresSubMatrix ct=new CountSquaresSubMatrix();
		int m[][]= {
				  {0,1,1,1},
				  {1,1,1,1},
				  {0,1,1,1}
		};
		System.out.println("Count: "+ct.countSquares(m));
	}
	  public int countSquares(int[][] matrix) {
	        int m=matrix.length;
	        int n=matrix[0].length;
	        int square[][]=new int[m][n];
	        for(int i=0;i<n;i++){
	            square[0][i]=matrix[0][i];
	        }
	         for(int i=0;i<m;i++){
	            square[i][0]=matrix[i][0];
	        }
	        for(int i=1;i<m;i++){
	            for(int j=1;j<n;j++){
	                if(matrix[i][j]==1){
	                   square[i][j]=min(square[i-1][j],square[i][j-1],square[i-1][j-1])+1;
	                    
	                }else{
	                    square[i][j]=0;
	                }
	                
	            }
	            
	        }
	        int total=0;
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(square[i][j]>=1){
	                    total+=square[i][j];
	                }
	            }
	        }
	        return total;
	    }
	    public int min(int a,int b,int c){
	        int temp=a>b?b:a;
	        int value=temp>c?c:temp;
	        return value;
	        
	    }
}
