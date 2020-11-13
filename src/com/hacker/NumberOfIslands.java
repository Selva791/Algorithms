package com.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class NumberOfIslands {
	public static void main(String[] args) {
		NumberOfIslands n = new NumberOfIslands();
		char grid[][] = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		// {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		/*
		 * { {'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'},
		 * {'0','0','0','0','0'}};
		 */
		System.out.println(n.numIslands(grid));
		
		
	}

	class Check {
		int x = 0;
		int y = 0;

		Check(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public boolean isSafe(int a, int b, int n, int m) {
		if (a >= 0 && b >= 0 && a < n && b < m) {
			return true;

		}
		return false;

	}

	public int numIslands(char[][] grid) {
		int count = 0;
		int m = grid[0].length;
		int n = grid.length;
		int value[][] = new int[n][m];
		boolean flag = false;
		boolean[][] visited = new boolean[n][m];
		Queue<Check> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					count++;
					q.add(new Check(i, j));
					while (!q.isEmpty()) {
						Check c = q.poll();

						int a[] = { 0, -1, 1, 0 };
						int b[] = { 1, 0, 0, -1 };
						for (int k = 0; k < 4; k++) {
							int p = c.x + a[k];
							int r = c.y + b[k];
							if (isSafe(p, r, m, n) && !visited[p][r]) {
									visited[p][r]=true;
								if (grid[p][r] == '1') {
									
									q.add(new Check(p, r));
									i = p;
									j = r;
								}
							}

						}

					}

				}

			}

		}

		return count;

	}

}
