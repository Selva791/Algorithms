package com.leetcode;

public class PathWithMaximumGold {
	public static void main(String[] args) {
		PathWithMaximumGold m=new PathWithMaximumGold();
		int grid[][]= {{0,6,0},
		              {5,8,7},
		              {0,9,0}};
		System.out.println(m.getMaximumGold(grid));
	}
	 public int getMaximumGold(int[][] grid) {
	        int n=grid.length;
	        int m=grid[0].length;
	        int res=0;
	        boolean visited[][]=new boolean[n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                   int t=0;
	                if(grid[i][j]>0){
	               
	                    t=helper(grid,i,j,0,visited);  
	                }
	                
	                if(t>res)res=t;
	            }
	            
	        }
	        return res;
	    }
	    public int helper(int[][] grid,int i,int j,int sum,boolean visited[][]){
	    if(i<grid.length&&j<grid[0].length&&i>=0&&j>=0&&!visited[i][j]&&grid[i][j]>0){
	            sum+=grid[i][j];
	            visited[i][j]=true;
	            int a=helper(grid,i+1,j,sum,visited);
	            int b=helper(grid,i,j+1,sum,visited);
	            int c=helper(grid,i-1,j,sum,visited);
	            int d=helper(grid,i,j-1,sum,visited);
	            int e=Math.max(a,b);
	             visited[i][j]=false;

	           return Math.max(Math.max(e,c),d);

	        }
	        return sum;
	    }
}
