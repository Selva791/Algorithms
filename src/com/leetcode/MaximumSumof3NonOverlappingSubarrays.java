package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaximumSumof3NonOverlappingSubarrays {
	public static void main(String[] args) {
		MaximumSumof3NonOverlappingSubarrays m = new MaximumSumof3NonOverlappingSubarrays();
		m.maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2);
	}
	private static final int N_SUBARRAYS = 3;
	private int[] nums, sums;
    private int k;
    private int[][] dp;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        dp = new int[nums.length][N_SUBARRAYS + 1];
        sums = collectSum();
        double c=Math.log(0.5)+Math.log(0.5);
        double d=Math.exp(c);

        int[] res = new int[N_SUBARRAYS];
        int idx = 0, pos = 0, size = N_SUBARRAYS;
        
        while (idx < N_SUBARRAYS) {
        	int a=maxSum(pos + k, size - 1);
        	int b=maxSum(pos, size);
            if (getSum(pos) + a ==b ) {
                res[idx++] = pos;
                pos = pos + k;
                size--;
            }
            else
                pos++;
        }
        
        return res;
    }
	private int maxSum(int pos, int size) {
        if (size == 0) return 0;
        if (dp[pos][size] != 0) return dp[pos][size];
		
		dp[pos][size] = -1;
		
        if (pos + k * size <= nums.length) {
            dp[pos][size] = getSum(pos) + maxSum(pos + k, size - 1);
            if (pos + 1 + k * size <= nums.length)
                dp[pos][size] = Math.max(dp[pos][size], maxSum(pos + 1, size));
        }

        return dp[pos][size];
    }
	
    private int getSum(int start) {
        if (start == 0) return sums[start + k - 1];
        else return sums[start + k - 1] - sums[start - 1];
    }

    private int[] collectSum() {
        int[] s = new int[nums.length];

        s[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            s[i] = s[i - 1] + nums[i];
        return s;
    }
}
