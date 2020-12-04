package com.leetcode;

import java.math.BigDecimal;

public class SmallestIntegerDivisibleByK {
	public static void main(String[] args) {
		SmallestIntegerDivisibleByK s=new SmallestIntegerDivisibleByK();
		System.out.println(s.smallestRepunitDivByK(9));
	}
	public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int r = 0;
        for (int N = 1; N <= K; ++N) {
            r = (r * 10 + 1) % K;
            if (r == 0) return N;
        }
        return -1;
    }
}
