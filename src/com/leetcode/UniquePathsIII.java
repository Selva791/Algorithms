package com.leetcode;

public class UniquePathsIII {
		public static void main(String[] args) {
			UniquePathsIII u=new UniquePathsIII();
			int g[][]= {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
			System.out.println(u.uniquePathsIII(g));
		}
		
		 public int uniquePathsIII(int[][] grid) {
		        int n=grid.length;
		        int m=grid[0].length;
		        int a=0;
		        int b=0;
		        boolean check=false;
		        boolean visited[][]=new boolean[n][m];
		        for(int i=0;i<n;i++){
		            for(int j=0;j<m;j++){
		                if(grid[i][j]==1){
		                    a=i;
		                    b=j;
		                   
		                }else if(grid[i][j]==-1) {
		                	visited[i][j]=true;
		                }
		                
		            }
		           
		        }
		       
		      //  visited[a][b]=true;
		        return pathFinder(a,b,grid,visited);
		    }
		    int count=0;
		    boolean flag=false;
		    public int pathFinder(int i,int j,int grid[][],boolean visited[][]){
		    	
		    	 
		        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
		            return 0;
		        }
		       // if(grid[i][j]==-1){visited[i][j]=false;}
		        if(grid[i][j]==2){
		        	visited[i][j]=true;
		           for(int m=0;m<visited.length;m++){
		            for(int n=0;n<visited[0].length;n++){
		                if(!visited[m][n]){
		                    flag=true;
		                   break;
		                }
		                
		            }
		           if(flag==true) break;
		          } 
		            if(flag==false){
		                return count+1;
		            }
		            flag=false;
		        }
		        if(grid[i][j]!=-1&&!visited[i][j]){
		            visited[i][j]=true;
		      count=pathFinder(i-1,j,grid,visited)+
		            pathFinder(i+1,j,grid,visited)+
		            pathFinder(i,j-1,grid,visited)+
		            pathFinder(i,j+1,grid,visited);
		             visited[i][j]=false;
		             return count;
		        }
		        return 0;
		    }
}
