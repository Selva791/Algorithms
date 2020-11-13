package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SortByParity {
	public static void main(String[] args) {
		int A[]= {3,1,2,4};
		SortByParity s=new SortByParity();
		s.sortArrayByParity(A);
		List<Integer> list=new ArrayList<Integer>();
	}

	public int[] sortArrayByParity(int[] A) {
		int n = A.length;
		for (int j = 0, i = 0; j < n; j++) {
			if (A[j] % 2 == 0) {
				int temp = A[j];
				A[j] = A[i];
				A[i++] = temp;

			}
		}
		return A;
	}
}
