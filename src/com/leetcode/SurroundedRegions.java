package com.leetcode;

public class SurroundedRegions {
	public static void main(String[] args) {
		SurroundedRegions sr=new SurroundedRegions();
		char board[][]= {
				{'O' ,'O' ,'O'},
				{'O', 'O', 'O'},
				{'O', 'O', 'O'},
				{'O', 'O', 'O'}};
		sr.solve(board);
	}
	 public void solve(char[][] board) {
	        int n=board.length;
	        if(n==0)return;
	        int m=board[0].length;
	        boolean visit[][]=new boolean [n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(board[i][j]=='O')
	                    finder(i,j,board,n,m,visit);
	                
	            }
	            
	        }
	        System.out.println();
	    }
	 boolean flag=false;
	    public void finder(int i,int j,char [][]board,int n,int m,boolean visit[][]){
	        if(i>=0&&j>=0&&j<m&&i<n&&board[i][j]=='O'&&visit[i][j]==false){
	            visit[i][j]=true;
	         finder(i+1,j,board,n,m,visit);
	         finder(i,j+1,board,n,m,visit);
	         finder(i-1,j,board,n,m,visit);
	         finder(i,j-1,board,n,m,visit);
	            if((i>0&&j>0)&&(i<n-1&&j<m-1)&&board[i][j]=='O'&&!flag){
	                board[i][j]='X';
	                return;
	                
	            }else if((i==0||j==0||i==n-1||j==m-1)&&board[i][j]=='O') {
	            	flag=true;
	            	return;
	            }
	        }
	      
	        return;
	    }
}
