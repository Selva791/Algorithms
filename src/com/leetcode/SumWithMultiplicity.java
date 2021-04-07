package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SumWithMultiplicity {
	public static void main(String[] args) {
		SumWithMultiplicity s=new SumWithMultiplicity();
		int []arr= {1,1,2,2,3,3,4,4,5,5};
		System.out.println(s.threeSumMulti(arr, 8));
	}

	int mod = (int) (Math.pow(10, 9) + 7);

	public int threeSumMulti(int[] arr, int target) {
		int n = arr.length;
		Map<Integer, Integer> mp = new HashMap<>();
		for (int a : arr)
			mp.put(a, mp.getOrDefault(a, 0) + 1);
		
		long count = 0L;
		int c1 = 1, c2 = 1, c3 = 1;
		for (int i = 0; i < n; i++) {

			if (i + 1 < n && arr[i] == arr[i + 1]) {
				c1++;
				continue;
			}
			int x = arr[i];
			for (int j = i + 1; j < n; j++) {
				if (j + 1 < n && arr[j] == arr[j + 1]) {
					c2++;
					continue;
				}
				int y = x + arr[j];
				if(y==target) {
					
				}
				for (int k = j + 1; k < n; k++) {
					int t = y + arr[k];
					if(k+1<n&&t==target&&arr[k]==arr[k+1]) {
						c3++;
						continue;
					}
					if (t == target) {
						
					}
				}
				c3 = 1;
				c2 = 1;

			}

			c1 = 1;
		}
		return (int) (count % mod);
	}
}
