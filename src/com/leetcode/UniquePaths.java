package com.leetcode;

public class UniquePaths {
	public static void main(String[] args) {
		UniquePaths u=new UniquePaths();
		System.out.println(u.uniquePaths(7, 3));
	}
	
	int count;
    public int uniquePaths(int m, int n) {
        count=0;
        boolean visited[][]=new boolean [n][m];
                
             paths(m,n,0,0,visited);
                
            
            
        
        return count;
    }
    public void paths(int m,int n,int i,int j,boolean visited[][]){
               //  System.out.println(i+" "+j);

        if(i>=0&&i<n&&j>=0&&j<m){
            if(i==n-1&&j==m-1){
                count++;
                return;
                
                
            }
            visited[i][j]=true;

            paths(m,n,i+1,j,visited);
            paths(m,n,i,j+1,visited);
            
        }
        
    }
}
