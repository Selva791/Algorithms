package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class OnesAndZeroes  {
	public static void main(String[] args) {
		String strs[] = {"10","0001","111001","1","0"};
				int m = 5, n = 3;
				OnesAndZeroes one=new OnesAndZeroes();
				System.out.println(one.findMaxForm(strs, m, n));
	}

	public int findMaxForm(String[] strs, int m, int n) {
		DP=new int[m+1][n+1][strs.length];
		return maxSubsets(strs, m, n, 0);
	
	}

	int[][][] DP ;

	public int maxSubsets(String[] strs, int m, int n, int index) {
	
		if (index >= strs.length||m+n==0) {
			return 0;
		}
		if (DP[m][n][index]>0) {
				return DP[m][n][index];
			
		}
		

		int c = 1;
		int c2=maxSubsets(strs, m, n, index + 1);
		int counts[] = new int[2];
		countNums(strs[index], counts);
		if (m >= counts[0] && n >= counts[1]) {
			c += maxSubsets(strs, m - counts[0], n - counts[1], index + 1);
		}
			
		DP[m][n][index]=Math.max(c2, c);
		return DP[m][n][index];

	}

	public void countNums(String nums, int counts[]) {
		int a = 0, b = 0;
		for (char c : nums.toCharArray()) {
			if (c == '1') {
				a += 1;
			} else if (c == '0') {
				b += 1;
			}
		}
		counts[0] = b;
		counts[1] = a;
	}
}
