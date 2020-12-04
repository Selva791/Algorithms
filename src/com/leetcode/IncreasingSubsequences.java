package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequences {
	public static void main(String[] args) {
		IncreasingSubsequences s=new IncreasingSubsequences();
		int nums[]= {4,6,7,7};
		System.out.println(s.findSubsequences(nums));
	}

	List<List<Integer>> result;

	public List<List<Integer>> findSubsequences(int[] nums) {
		int n = nums.length;
		result = new ArrayList<>();
		List<Integer> temp=new ArrayList<>();
		for (int i = 0; i <nums.length; i++) {
			
			subsequences(nums, i, temp, Integer.MIN_VALUE);
			
		}
		return result;
	}

	public void subsequences(int nums[], int start, List<Integer> values, int prev) {

		if (values.size() > 1) {
			result.add(new ArrayList<>(values));
		}
		if (start >= nums.length)
			return;


			if (nums[start] >= prev) {
				values.add(nums[start]);
				subsequences(nums,start+1, values, nums[start]);
				values.remove(values.size() - 1);
			}

		
		return;
	}
}
