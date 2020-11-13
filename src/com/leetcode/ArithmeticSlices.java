package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlices {
	public static void main(String[] args) {
		ArithmeticSlices as=new ArithmeticSlices();
		int A[]= {1, 2, 3, 4,5,6};
		System.out.println(as.numberOfArithmeticSlices(A));
	}

	public int numberOfArithmeticSlices(int[] A) {
		int n = A.length;
		if (n < 3)
			return 0;
		slice(A, 0);
		return count;
	}

	int count = 0;
	Map<String, Integer> cache = new HashMap<>();

	public void slice(int A[], int index) {
		if (index >= A.length) {
			return;
		}

		for (int i = index; i+2 < A.length; i++) {
			if (check(index, i+2, A))
				count++;
			
			
		}
		slice(A, index+1);
		return;
	}

	public boolean check(int a, int b, int A[]) {
		String key = a + "_" + b;
		System.out.println(key);
		int t=b-1;
		String s=a+"_"+t;
		if (cache.containsKey(s)) {
			int d = A[b] - A[t];
			if (d == cache.get(s)) {
				cache.put(key, d);
				return true;
			} else {
				return false;
			}
		}
		int diff = A[a + 1] - A[a];
		a += 1;
		while (a < b) {
			int temp = A[a + 1] - A[a];
			if (diff != temp) {
				return false;
			}
			a+=1;
		}
		cache.put(key,diff);
		return true;
	}

}
