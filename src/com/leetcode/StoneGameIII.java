package com.leetcode;

public class StoneGameIII {
	public static void main(String[] args) {
		int stone[] = {-1,-2,-3};
		StoneGameIII st = new StoneGameIII();
		System.out.println(st.stoneGameIII(stone));
	}

	int dp[][][];

	public String stoneGameIII(int[] stoneValue) {
		int n = stoneValue.length;
		dp = new int[n][2][];
		int res[] = stoneGame(stoneValue, 0, 0, n);
		if (res[0] > res[1]) {
			return "Alice";
		} else if (res[0] < res[1]) {
			return "Bob";
		}
		return "Tie";
	}

	public int[] stoneGame(int[] stoneValue, int play, int s, int n) {

		if (s >= n) {
			return new int[] { 0, 0 };
		}
		if (dp[s][play] != null)
			return dp[s][play];

		int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, v = 0, c = 0;

		if (play == 0) {
			for (int i = s; i < n && i < s + 3; i++) {
				v += stoneValue[i];
				int p[] = stoneGame(stoneValue, 1, i + 1, n);
				a = Math.max(p[0] + v, a);
				b = p[1];
			}

		} else if (play == 1) {
			for (int i = s; i < n && i < s + 3; i++) {
				c += stoneValue[i];
				int p[] = stoneGame(stoneValue, 0, i + 1, n);
				b = Math.max(p[1] + c, b);
				a = p[0];
			}
		}

		dp[s][play] = new int[] { a, b };
		return dp[s][play];
	}
}
