package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ContiguousArray {
	public static void main(String[] args) {
		ContiguousArray ca = new ContiguousArray();
		int nums[] = { 0, 1, 1, 0, 1, 1, 1, 0 };
		// {0,1,0,1};
		// {0,1,1,0,1,1,1,0};
		// [1,1,1,1,1,1,1,1]
		System.out.println(ca.findMaxLength(nums));
	}

	public int findMaxLength(int[] nums) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				sum--;

			} else {
				sum++;
			}

			if (map.get(sum) == null) {
				map.put(sum, i + 1);

			} else
				res = Math.max(res, (i + 1) - map.get(sum));
		}
		return res;
	}
}
