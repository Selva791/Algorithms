package com.leetcode;

import java.util.TreeMap;

public class GooglePreSum {
	public static void main(String[] args) {
		GooglePreSum g=new GooglePreSum();
		int nums[]= {10,2, 24,30, -10, -50, 83, 100};
		int k=53;
		g.findSubArrayCloseToK(nums, k);
	}

	private int findSubArrayCloseToK(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, -1);
		int sum = 0;
		int diff = Integer.MAX_VALUE;
		int result = 0;
		int start = -1;
		int end = -1;
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
			Integer low = map.floorKey(sum - k);
			if (low != null) {
				if (diff > sum - k - low) {
					diff = sum - k - low;
					start = map.get(low) + 1;
					end = i;
				}
			}
			Integer high = map.ceilingKey(sum - k);
			if (high != null) {
				if (diff > high - (sum - k)) {
					diff = high - (sum - k);
					start = map.get(high) + 1;
					end = i;
				}
			}
			map.put(sum, i);
		}
		System.out.println(start + " " + end);
		return diff;
	}
}
