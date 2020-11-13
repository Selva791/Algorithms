package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		NQueens n=new NQueens();
		n.solveNQueens(4);
	}
	List<List<String>> result;

	public List<List<String>> solveNQueens(int n) {
		result = new ArrayList<>();
		char board[][] = new char[n][n];
		for (char b[] : board) {
			Arrays.fill(b, '.');

		}
		List<String> res = new ArrayList<>();
		backTrack(board, 0);
		return result;

	}

	public void backTrack(char board[][], int col) {
		if (col == board.length) {
			List<String> res = new ArrayList<>();

			construct(board, res);
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (validate(board, i, col)) {
				board[i][col] = 'Q';
				backTrack(board, col + 1);
				board[i][col] = '.';

			}

		}
	}

	public boolean validate(char board[][], int x, int y) {
		int a = x + y;
		int b = x - y;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'Q' && (a == i + j || b == i - j||x==i)) {
					return false;
				}
			}

		}
		return true;
	}

	public void construct(char board[][], List<String> res) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (char b[] : board) {
			for (char c : b) {
				sb.append(c);
			}
			sb.append(',');
		}
		sb.append(']');
		res.add(sb.toString());
		result.add(res);
	}
}
