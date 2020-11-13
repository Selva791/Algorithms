package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter {
	public static void main(String[] args) {
		IslandPerimeter ip=new IslandPerimeter();
		int grid[][]= {
				 {0,1,0,0},
				 {1,1,1,0},
				 {0,1,0,0},
				 {1,1,0,0}};
		System.out.println(ip.islandPerimeter(grid));
	}

	class Perimeter {
		int x, y;

		Perimeter(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public boolean isSafe(int x, int y, int n, int m) {
		if (x >= 0 && x < n && y >= 0 && y < m) {
			return true;

		}
		return false;
	}

	public int islandPerimeter(int[][] grid) {

		int n = grid.length;
		if (n == 0) {
			return 0;
		}
		int m = grid[0].length;
		int count = 0;
		boolean visited[][] = new boolean[n][m];
		Queue<Perimeter> q = new LinkedList<>();
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					q.add(new Perimeter(i, j));
					visited[i][j]=true;

					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		while (!q.isEmpty()) {
			Perimeter p = q.poll();
			int x[] = { 0, 1, 0, -1 };
			int y[] = { 1, 0, -1, 0 };
			for (int i = 0; i < 4; i++) {
				int a = p.x + x[i];
				int b = p.y + y[i];
				if (!isSafe(a, b, n, m)) {
					count += 1;

				} else if (isSafe(a, b, n, m) && grid[a][b] == 1 && !visited[a][b]) {
					visited[a][b] = true;
					q.add(new Perimeter(a, b));

				} else if (isSafe(a, b, n, m) && grid[a][b] == 0 && !visited[a][b]) {
					count += 1;

				}

			}

		}
		return count;
	}
}
