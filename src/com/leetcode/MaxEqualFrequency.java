package com.leetcode;
//https://leetcode.com/problems/maximum-equal-frequency/
//NOt done
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class MaxEqualFrequency {
 public static void main(String[] args) {
	 MaxEqualFrequency mp=new MaxEqualFrequency();
	 int []nums={1,1,2,2,3,3,3,4,4,75,20,67,37,24,33,71,1,91,60,65,53,70,96,77,52,4,57,51,8,63,79,57,26,99,80,24,39,89,70
			,73,70,92,56,52,45,39,6,45,41,94,55,92,24,21,76,25,28,58,53,35,95,98,94,85,35,
			60,25,85,29,66,25,38,22,77,54,85,100,65,30,7,8,49,66,38,79,4,99,49,63,63,69,82,43,38,83,11,56,85,25,38,61,40,36,67,84};
		
	System.out.println(mp.maxEqualFreq(nums));
 }
 public int maxEqualFreq(int[] nums) {

 Map<Integer, Integer> countByNum = new HashMap<>();
	Map<Integer, Integer> countByCount = new HashMap<>();
	for (int num : nums) {
		countByNum.put(num, countByNum.getOrDefault(num, 0)+1);
	}
	for (int count : countByNum.values()) {
		countByCount.put(count, countByCount.getOrDefault(count, 0)+1);
	}
	for (int i = nums.length-1; i >= 0; i--) {
		if (valid(countByCount)) {
			return i+1;
		}
		int num = nums[i];
		int count = countByNum.get(num);
		countByNum.put(num, countByNum.get(num)-1);
		countByCount.put(count, countByCount.get(count)-1);
		if (countByCount.get(count) == 0) {
			countByCount.remove(count);
		}
		if (count > 1) {
			countByCount.put(count-1, countByCount.getOrDefault(count-1, 0)+1);
		}
	}
	return 0;
}

private boolean valid(Map<Integer, Integer> countByCount) {
	if (countByCount.size() == 1) {
		// [1, 2, 3] or [1, 1, 1]
		return countByCount.keySet().iterator().next() == 1 || countByCount.values().iterator().next() == 1;
	}
	if (countByCount.size() != 2) {
		return false;
	}
	int smallerCount = Integer.MAX_VALUE;
	int largerCount = Integer.MIN_VALUE;
	for (int count : countByCount.keySet()) {
		smallerCount = Math.min(smallerCount, count);
		largerCount = Math.max(largerCount, count);
	}
	// [2, 3, 3, 1] or [2, 2, 1, 3, 3]
	return (largerCount-smallerCount == 1 && countByCount.get(largerCount) == 1) || (smallerCount == 1 && countByCount.get(smallerCount) == 1);
}
}