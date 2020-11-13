package com.leetcode;

public class GameOfLife {
	public static void main(String[] args) {
		GameOfLife g=new GameOfLife();
		int board[][]= {
		                 {0,1,0},
		                 {0,0,1},
		                 {1,1,1},
		                 {0,0,0}
		               };
		g.gameOfLife(board);;
		
	}

	 public void gameOfLife(int[][] board) {
	        
	        int n=board.length;
	        int m=board[0].length;
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	               int lives= helper(i,j,m,n,board);
	                if(board[i][j]==0&&lives==3){
	                    board[i][j]=2;
	                }else if(board[i][j]==1&&lives>1&&lives<=3){
	                    board[i][j]=3;
	                }
	                
	            }
	            
	        }
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                board[i][j]>>=1;
	            }
	        }
	       // return board;
	    }
	    public int helper(int i,int j,int m,int n,int [][]board){
	        int x[]={-1,-1,0,1,1,1,0,-1};
	        int y[]={ 0, 1,1,1,0,-1,-1,-1};
	        int lives=0;
	        for(int k=0;k<8;k++){
	            int a=i+x[k];
	            int b=j+y[k];
	            if(a>=0&&a<n&&b>=0&&b<m)
	                lives+=board[a][b]&1;
	        }
	        return lives;
	    }
}
