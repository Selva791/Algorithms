package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutivesIII {

	public static void main(String[] args) {
		MaxConsecutivesIII m=new MaxConsecutivesIII();
		int A[]= {0,0,0,1};
		int K=4;
		System.out.println(m.longestOnes(A, K));
	}

	public int longestOnes(int[] A, int K) {

		int n = A.length;
		List<Integer> set = new ArrayList<>();
		int count = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] == 0)
				set.add(i);
		}
		int index = 0;
		count+=set.get(0);
		for (int i = set.get(0); i < n; i++) {

			if (A[i] == 0 && K == 0) {

				if (max < count)
					max = count;
				int g = 0;
				if (index == 0) {
					g = set.get(index++) + 1;
				} else {
					g = set.get(index)-set.get(index - 1);
					index++;
				}
				count -= g;
				K+=1;
			}

			if (A[i] == 0) {

				K -= 1;
				count += 1;
			} else if (A[i] == 1) {
				count += 1;
			}

		}
		if (max < count)
			max = count;
		return max;
	}

}
