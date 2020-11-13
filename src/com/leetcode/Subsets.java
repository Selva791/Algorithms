package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int nums[] = { 1, 2, 3 };
		System.out.println(s.subsets(nums));
	}

	List<List<Integer>> total;

	public List<List<Integer>> subsets(int[] nums) {
		total = new ArrayList<>();
		int n = nums.length;
		List<Integer> result = new ArrayList<>();

		permute(nums, 0, n, result);
		return total;

	}

	public List<Integer> permute(int[] nums, int index, int n, List<Integer> result) {
		total.add(new ArrayList<>(result));

		for (int i = index; i < n; i++) {
			result.add(nums[i]);
			List<Integer> t = permute(nums, i + 1, n, result);
			result.remove(result.size()-1);
		}
		return result;

	}
}
