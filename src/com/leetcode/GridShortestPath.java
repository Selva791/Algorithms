package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class GridShortestPath {
	public static void main(String[] args) {
		// [[0,1,0,1],[0,1,0,0],[0,0,1,0],[1,0,0,1],[0,1,0,0]]
		// 18
		// [[0,1,0,0,0,1,0,0],[0,1,0,1,0,1,0,1],[0,0,0,1,0,0,1,0]]
		// 1
		int grid[][] = { { 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0, 0, 1, 0 } };
		int k = 1;
		GridShortestPath g = new GridShortestPath();
		System.out.println(g.shortestPath(grid, k));
	}

	int max = Integer.MAX_VALUE;
	boolean visit[][];

	class pair {
		int x, y, k, c;

		pair(int x, int y, int k, int c) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.c = c;

		}
	}

	public int shortestPath(int[][] grid, int k) {
		max = Integer.MAX_VALUE;
		visit = new boolean[grid.length][grid[0].length];
		visit[0][0] = true;
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(grid.length - 1, grid[0].length - 1, k, 0));
		return pathFinder(grid, 0, q);
	}

	public int pathFinder(int[][] grid, int count, Queue<pair> q) {
		if (grid.length == 1 && grid[0].length == 1) {
			return 0;
		}
		int x[] = { -1, 0, 1, 0 };

		int y[] = { 0, -1, 0, 1 };

		while (!q.isEmpty()) {
			pair p = q.poll();
			int x1 = p.x;
			int y1 = p.y;
			int c = p.c;
			int k = p.k;
			System.out.println(x1 + " " + y1);
			for (int i = 0; i < 4; i++) {
				if (grid[x1][y1] == 0 || (grid[x1][y1] == 1 && k >= 0)) {
					int n = x1 + x[i];
					int m = y1 + y[i];
					if (n == 0 && m == 0) {
						return max = Math.min(c + 1, max);
					}
					if (isSafe(n, m, grid)) {
						if (grid[n][m] == 0 && visit[n][m] == false) {
							visit[n][m] = true;
							q.add(new pair(n, m, k, c + 1));

						} else if (grid[n][m] == 1 && k >= 1 && visit[n][m] == false) {
							visit[n][m] = true;
							q.add(new pair(n, m, k - 1, c + 1));

						}
					}

				}
			}
		}
		return -1;
	}

	public boolean isSafe(int x1, int y1, int grid[][]) {
		if (x1 >= 0 && y1 >= 0 && grid.length > x1 && grid[0].length > y1) {
			return true;

		}
		return false;
	}
}
