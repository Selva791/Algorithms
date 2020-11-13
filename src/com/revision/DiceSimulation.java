package com.revision;

import java.util.Arrays;

public class DiceSimulation {
	public static void main(String[] args) {
		int []rollMax= {1,1,2,2,2,3};
		System.out.println(dieSimulator(2, rollMax));
	}
	  public static int dieSimulator(int n, int[] rollMax) {
	        int mod = (int)1e9 + 7;
	        long dp[][] = new long[n + 1][6];
	        long res = 0;

	        Arrays.fill(dp[1], 1);

	        for(int i = 2; i <= n; i++) {
	            for(int j = 0; j < 6; j++) {
	                for(int k = 0; k < 6; k++) {
	                    if(j != k) {
	                        dp[i][j] = (dp[i][j] + dp[i - 1][k])  % mod;
	                    }
	                    else {
	                        int cnt = 2;
	                        for(; cnt <= rollMax[j] && cnt < i; cnt++) {
	                            for(int t = 0; t < 6; t++) {
	                                if(t == j) {
	                                    continue;
	                                }
	                                dp[i][j] = (dp[i][j] + dp[i - cnt][t]) % mod;
	                            }
	                        }
	                        if(cnt <= rollMax[j] && cnt == i) {
	                            dp[i][j] = (dp[i][j] + 1) % mod;
	                        }
	                    }
	                }
	            }
	        }
	        for(int i = 0; i < 6; i++) {
	            res = (res + dp[n][i]) % mod;
	        }
	        return (int)res;
	  }
}
