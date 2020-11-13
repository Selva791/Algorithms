package com.hacker;

public class DungeonGame {
	public static void main(String[] args) {
		DungeonGame d=new DungeonGame();
		int s[][]= {{-3,5}};
		System.out.println(d.calculateMinimumHP(s));
		
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int n = dungeon.length;
		if (n == 0) {
			return 1;
		}
		int m = dungeon[0].length;

		if (n == 1 && m == 1) {
			if (dungeon[0][0] > 0) {
				System.out.println("here");
				return 1;
			} else {
				return Math.abs(dungeon[0][0]) + 1;

			}
		}
		int dp[][] = new int[n][m];
		dp[n - 1][m - 1] = dungeon[n - 1][m - 1];
		for (int i = m - 2; i >= 0; i--) {
			int s = dungeon[n - 1][i] + dp[n - 1][i + 1];
			if (s > 0) {
				dp[n - 1][i] = 0;
			} else {
				dp[n - 1][i] = s;
			}

		}
		for (int i = n - 2; i >= 0; i--) {
			int s = dungeon[i][m - 1] + dp[i + 1][m - 1];
			if (s > 0)
				dp[i][m - 1] = 0;
			else
				dp[i][m - 1] = s;
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = m - 2; j >= 0; j--) {

				int s = Math.max(dp[i][j + 1], dp[i + 1][j]);
				int a = dungeon[i][j] + s;
				if (s > 0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = a;
				}

			}
		}
		// System.out.println(dp[0][1]);
		// System.out.println(dp[0][2]);
		// System.out.println(dp[0][2]);

		return Math.abs(dp[0][0]) + 1;
	}
}
