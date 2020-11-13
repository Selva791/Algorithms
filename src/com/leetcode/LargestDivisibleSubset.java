package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	public static void main(String[] args) {
		int arr[]= {546,669};
				// {1,2,3};
		LargestDivisibleSubset l=new LargestDivisibleSubset();
		System.out.println(l.largestDivisibleSubset(arr));
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		List<Integer> result = new ArrayList<>();
		int dp[] = new int[n];
		Arrays.sort(nums);
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					if (max < dp[i]) {
						max = dp[i];
					}

				}

			}

		}
		int prev = -1;
		int v = n - 1;
		while (v >= 0) {
			int s = nums[v];
			if (dp[v] == max && (prev == -1 || prev % s == 0)) {
				prev = s;
				result.add(s);
				max--;
			}
			v--;


		}
		return result;

	}
}
