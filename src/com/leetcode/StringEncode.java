package com.leetcode;

import java.util.Arrays;

public class StringEncode {
	public static void main(String[] args) {
		StringEncode se = new StringEncode();
		System.out.println(se.encode("GCATTATTATTGC"));
	}

	private int encode(String s) {
		int n = s.length();
		int dp[][] = new int[n][n];
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = 1;
		}
		for (int d = 2; d <= n; d++)
			for (int start = 0; start + d - 1 < n; start++) {
				int end = start + d - 1;
				int opt = d;
				for (int k = 1; k < d; k++)
					if (d % k == 0) {
						boolean eq = true;
						for (int l = start + k; l <= end; l++)
							if (s.charAt(l) != s.charAt(l - k)) {
								eq = false;
								break;
							}

						if (eq)
							opt = Math.min(opt, dp[start][start + k - 1]);
					}

				for (int k = start; k < end; k++)
					opt = Math.min(opt, dp[start][k] + dp[k + 1][end]);

				dp[start][end] = opt;
			}
		return dp[0][n - 1];
	}

}
