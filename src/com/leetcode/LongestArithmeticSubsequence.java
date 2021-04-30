package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
	public static void main(String[] args) {
		int A[] = {9,4,7,2,10};
		LongestArithmeticSubsequence l = new LongestArithmeticSubsequence();
		System.out.println(l.longestArithSeqLength(A));
	}

	int ans = 0;

	public int longestArithSeqLength(int[] A) {
		 int res = 2, n = A.length;
	        HashMap<Integer, Integer>[] dp = new HashMap[n];
	        for (int j = 0; j < A.length; j++) {
	            dp[j] = new HashMap<>();
	            for (int i = 0; i < j; i++) {
	                int d = A[j] - A[i];
	                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
	                res = Math.max(res, dp[j].get(d));
	            }
	        }
	        return res;
	}

}
