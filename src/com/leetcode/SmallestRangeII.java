package com.leetcode;

import java.util.Arrays;

public class SmallestRangeII {
	public static void main(String[] args) {
		int A[] = {1,3,10};
		int k = 3;
		SmallestRangeII s = new SmallestRangeII();
		System.out.println(s.smallestRangeII(A, k));
	}

	public int smallestRangeII(int[] A, int K) {
		int n = A.length-1;
		if (n == 1)
			return 0;

		Arrays.sort(A);
		int low=A[0];
		int high=A[n];
		int ans=high-low;
		for (int i = 0; i<n; i++) {
			int min=Math.min(low+K, A[i+1]-K);
			//System.out.println("Min: "+ (A[i+1]-K));
			int max=Math.max(high-K, A[i]+K);
			System.out.println("Max: "+(A[i]+K));
			ans=Math.min(max-min,ans);
		}
		return ans;
	}

}
