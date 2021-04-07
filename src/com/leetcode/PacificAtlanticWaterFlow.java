package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class PacificAtlanticWaterFlow {
	public static void main(String[] args) {
		PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();
		int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		TreeMap<Integer,Integer> tr=new TreeMap<>();
		int y=1000000000;
		System.out.println(p.pacificAtlantic(matrix));
	}

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> result = new ArrayList<>();
		int n = matrix.length, m = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();
		boolean visited[][] = new boolean[n][m];

		Boolean dp[][] = new Boolean[n][m];
		int x[] = { -1, 0, 1, 0 };
		int y[] = { 0, 1, 0, -1 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				boolean visit[][] = new boolean[n][m];
				visit[i][j] = true;
				q.offer(new int[] { i, j });
				int u = -1, v = -1;
				while (!q.isEmpty()) {
					int temp[] = q.poll();
					if (temp[0] == 0 || temp[1] == 0) {
						u = 0;
					}
					if (temp[0] == n - 1 || temp[1] == m - 1) {
						v = 0;
					}
					if (u == 0 && v == 0) {
						dp[i][j] = true;
						q.clear();
						break;
					}
					for (int k = 0; k < 4; k++) {
						int a = temp[0] + x[k];
						int b = temp[1] + y[k];
						
						if (isSafe(a, b, n, m) && matrix[temp[0]][temp[1]] >=matrix[a][b] && !visit[a][b]) {
							visit[a][b] = true;
							
							if (dp[a][b] != null&&dp[a][b]) {
								dp[i][j] = true;
								u=0;v=0;
								q.clear();
								break;
							}else {
								q.offer(new int[] { a, b });
							}
							
						}
					}
				}
				if(q.isEmpty()&&u!=0||v!=0) {
					dp[i][j]=false;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dp[i][j] != null && dp[i][j]) {
					List<Integer> r = new ArrayList<>();
					r.add(i);
					r.add(j);
					result.add(r);
				}
			}
		}
		return result;
	}

	public boolean isSafe(int x, int y, int n, int m) {

		if (x < n && x >= 0 && y < m && y >= 0) {
			return true;
		}
		return false;
	}

}
