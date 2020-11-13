package com.hacker;

public class NqueenBacktracking {

	static int N = 4;
	static int k = 1;

	private static boolean solveNQUtil(int[][] board, int col) {
		// TODO Auto-generated method stub

		if (col == N) {

		}
		for (int i = 0; i < board.length; i++) {
			if (isSafInside(board, i, col)) {
					board[i][col]=1;
					
					solveNQUtil(board,col+1);
					board[i][col]=0;
					
			}
		}

		return false;
	}

private static boolean isSafInside(int[][] board, int row, int col) {
		// TODO Auto-generated method stub
	int i ,j;
	for ( i = 0; i <col; i++) {
		if(board[row][i]==1) {
			return false;
		}
		}
	for ( i = row, j=col; i >=0&&j>=0; --i,--j) {
		if(board[i][j]==1) {
			return false;
		}
	}
	for ( i = row, j=0; i >=0&&j<N; --i,++j) {
		if(board[i][j]==1) {
			return false;
		}
	}
		
	
	
		return true;
	}

	public static void main(String[] args) {
		int board[][] = new int[N][N];

		if (solveNQUtil(board, 0) == false) {
			System.out.printf("Solution does not exist");
		}

	}

}
