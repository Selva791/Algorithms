package com.hacker;

public class BattleShipOnBoard {
	public static void main(String[] args) {
		BattleShipOnBoard b=new BattleShipOnBoard();
		char[][] board= {{'X','.','.','X'},
						 {'.','.','.','X'},
						 {'.','.','.','X'}};
		System.out.println(b.countBattleships(board));
						 
		}
	

	public int countBattleships(char[][] board) {
		int n = board.length;
		int m = board[0].length;
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'X') {
					c++;
					sink(board, i, j);

				}

			}

		}
		return c;
	}

	public void sink(char[][] board, int i, int j) {
		if (i >=0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'X') {
			board[i][j] = '.';
			sink(board, i - 1, j);
			sink(board, i + 1, j);
			sink(board, i, j - 1);
			sink(board, i, j + 1);
		}
		return;

	}
}
