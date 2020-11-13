package com.Amazon;

import java.util.PriorityQueue;

public class MaxValuePathScore {
	public static void main(String[] args) {
		MaxValuePathScore m=new MaxValuePathScore();
		int grid[][]= {{7,5,3},
				       {2,0,9},
				       {4,5,9}};
		System.out.println(m.maxPathScore(grid));
	}

	public int maxPathScore(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		queue.add(new int[] { grid[0][0], 0, 0, grid[0][0] });
		int[] dr = new int[] { 1, 0, -1, 0 };
		int[] dc = new int[] { 0, -1, 0, 1 };
		boolean[][] seen = new boolean[m][n];
		seen[0][0] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[1] == m - 1 && curr[2] == n - 1)
				return curr[3];

			for (int i = 0; i < 4; i++) {
				int r = curr[1] + dr[i];
				int c = curr[2] + dc[i];
				if (r >= 0 && r < m && c >= 0 && c < n && !seen[r][c]) {
					queue.add(new int[] { grid[r][c], r, c, Math.min(grid[r][c], curr[3]) });
					seen[r][c] = true;
				}
			}
		}
		return -1;
	}
}
