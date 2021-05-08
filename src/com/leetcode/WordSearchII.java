package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {
	public static void main(String[] args) {
		WordSearchII w = new WordSearchII();
		char c[][] = {{'a','a'}};
			//{ { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };
		String []words={"aaa"};
		System.out.println(w.findWords(c, words));
	}

	public List<String> findWords(char[][] board, String[] words) {
		int len = words.length;
		int n = board.length;
		int m = board[0].length;
		Map<Character, List<List<Integer>>> mp = new HashMap<>();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (!mp.containsKey(board[i][j])) {
					List<List<Integer>> t = new ArrayList<>();
					mp.put(board[i][j], t);
				}
				List<List<Integer>> t = mp.get(board[i][j]);
				t.add(Arrays.asList(i, j));
			}
		}

		for (String s : words) {
			List<List<Integer>> tr = mp.get(s.charAt(0));
			if (tr == null)
				continue;
			for (List<Integer> a : tr) {
				boolean visited[][] = new boolean[n][m];
				 visited[a.get(0)][a.get(1)]=true;
				if (check(s, a.get(0), a.get(1), board, n, m, visited, 1)) {
					res.add(s);
				}
			}
		}
		return res;
	}

	int x[] = { -1, 0, 1, 0 };
	int y[] = { 0, 1, 0, -1 };

	public boolean check(String str, int c, int d, char[][] board, int n, int m, boolean visited[][], int s) {

		if (s == str.length()) {
			return true;
		}

		for (int i = 0; i < 4; i++) {
			int a = c + x[i];
			int b = d + y[i];
			if (isSafe(a, b, n, m) && !visited[a][b] && str.charAt(s) == board[a][b]) {
				visited[a][b] = true;
				if (check(str, a, b, board, n, m, visited, s + 1)) {
					return true;
				} else {
					visited[a][b] = false;
				}
			}
		}
		return false;
	}

	public boolean isSafe(int i, int j, int n, int m) {
		if (i >= 0 && j >= 0 && i < n && j < m) {
			return true;
		}
		return false;
	}
}
