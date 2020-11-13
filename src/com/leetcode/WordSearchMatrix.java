package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearchMatrix {
	public static void main(String[] args) {
		char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCESEEEFS";
		WordSearchMatrix w = new WordSearchMatrix();
		System.out.println(w.exist(board, word));
	}

	public boolean isSafe(int x, int y, int n, int m) {
		if (x >= 0 && y >= 0 && x < n && y < m) {
			return true;
		}
		return false;
	}

	public boolean exist(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				boolean visited[][] = new boolean[n][m];

				if(check(board, i, j, 0, word, visited)) {
					return true;
				}

			}
		}
		return false;

	}

	private boolean check(char[][] board, int i, int j, int k, String word, boolean visited[][]) {
		if (k == word.length()) {
			return true;
		}
		if (k < word.length() && isSafe(i, j, board.length, board[0].length) && word.charAt(k) == board[i][j]&&!visited[i][j]) {
			visited[i][j] = true;
			if(check(board, i + 1, j, k + 1, word, visited)||
			check(board, i, j + 1, k + 1, word, visited)||
			check(board, i - 1, j, k + 1, word, visited)||
			check(board, i, j - 1, k + 1, word, visited))return true;
			visited[i][j] = false;

		}
		
		return false;

	}
}
