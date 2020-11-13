package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
	public static void main(String[] args) {
		PerfectSquares p = new PerfectSquares();
		int n = 4;
		System.out.println(p.numSquares(n));
	}

	public int numSquares(int n) {
		if (n == 0 || n == 1)
			return 1;

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			if ((i * i) <=n) {
				list.add(i * i);

			} else {
				break;
			}

		}
		int m = list.size();
		int dp[][] = new int[m][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == 0) {
					continue;
				} else {
					if (i == 0 && list.get(i) < j) {
						int t = j - list.get(i);
						dp[i][j] = dp[i][t] + 1;
					} else if (i >= 0 && list.get(i) < j) {
						int t = j - list.get(i);
						dp[i][j] = dp[i][t] + 1;
						dp[i][j] = Math.min(dp[i - 1][j], dp[i][t] + 1);
					} else if (list.get(i) == j) {
						dp[i][j] = 1;

					} else if (list.get(i) > j) {
						dp[i][j] = dp[i - 1][j];
					}

				}
			}
		}

		return dp[m - 1][n];
	}

	/*
	 * public int numSquares(int n) {
	 * 
	 * int dp[]=new int[n+1]; for(int i=1;i<=n;i++){ int x=1;int sq=1; int min=1;
	 * while(sq<=i){ min=Math.min(min,1+dp[i-sq]); sq=x*x; x++; } dp[i]=min;
	 * 
	 * } return dp[n]; }
	 */
}
