package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumDominoRotationsForEqualRow {
	public static void main(String[] args) {
		MinimumDominoRotationsForEqualRow m=new MinimumDominoRotationsForEqualRow();
		int A[]= {2,1,2,4,2,2};
		int B[]= {5,2,6,2,3,2};
				
				System.out.println(m.minDominoRotations(A, B));
	}

	public int minDominoRotations(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;
		Map<Integer, Integer> a = new HashMap<>();
		Map<Integer, Integer> b = new HashMap<>();

		for (int i = 0; i < n; i++) {
			a.put(A[i], a.getOrDefault(A[i], 0) + 1);

		}
		for (int i = 0; i < m; i++) {
			b.put(B[i], b.getOrDefault(B[i], 0) + 1);

		}
		int min=0;
		int count =Integer.MAX_VALUE;
		int r=0;
		for (int i = 1; i < 7; i++) {

			if (a.containsKey(i) && b.containsKey(i)) {
				int a1 = a.get(i);
				int b1 = b.get(i);
				if(a1==n||b1==m) {
					return 0;
				}
				if (b1 + a1 >= n) {
					if(a1>b1) {
						for (int j = 0; j < n; j++) {
							if (A[j] != i && B[j] == i) {
								r += 1;
							} else if(A[j] != i) {
								break;
							}
						}
					}else if(b1>a1) {
						for (int j = 0; j < n; j++) {
							if (B[j] != i && A[j] == i) {
								r += 1;
							} else if(B[j] != i) {
								break;
							}
						}
					}
					
				}
				
					if(r!=0&&(r+a1==n||r+b1==m))
					count=Math.min(count, r);
					r=0;
			}
		}
			return count==Integer.MAX_VALUE?-1:count;
	}
}
