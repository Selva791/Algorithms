package com.leetcode;

public class MaximumSumTwoSubArrays {
	public static void main(String[] args) {
		MaximumSumTwoSubArrays m=new MaximumSumTwoSubArrays();
		int A[]= {8,20,6,2,20,17,6,3,20,8,12};
		int L=5;
		int M=4;
		System.out.println(m.maxSumTwoNoOverlap(A, L, M));
	}

	public int maxSumTwoNoOverlap(int[] A, int L, int M) {
		   int res = 0, Lsum = 0, Lmax = 0, Msum = 0, Mmax = 0;
	        for (int i = 0; i < A.length; ++i) {
	            Msum += A[i];
	            if (i - M >= 0) Msum -= A[i - M];
	            if (i - M >= 0) Lsum += A[i - M];
	            if (i - M - L >= 0) Lsum -= A[i - L - M];
	            Lmax = Math.max(Lmax, Lsum);
	            System.out.println(Lmax+" "+Msum);
	            res = Math.max(res, Lmax + Msum);
	        }
	        Lsum = Lmax = Msum = Mmax = 0;
	        for (int i = 0; i < A.length; ++i) {
	            Lsum += A[i];
	            if (i - L >= 0) Lsum -= A[i - L];
	            if (i - L >= 0) Msum += A[i - L];
	            if (i - M - L >= 0) Msum -= A[i - L - M];
	            Mmax = Math.max(Mmax, Msum);
	            res = Math.max(res, Mmax + Lsum);
	        }
	        return res;
	}
}
