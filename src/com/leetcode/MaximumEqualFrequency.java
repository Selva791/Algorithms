package com.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaximumEqualFrequency {
	public static void main(String[] args) {
		int[] nums = {1,1,2,2,3,3,3,4,4,75,20,67,37,24,33,71,1,91,60,65,53,70,96,77,52,4,57,51,8,63,79,57,26,99,80,24,39,89,70
				,73,70,92,56,52,45,39,6,45,41,94,55,92,24,21,76,25,28,58,53,35,95,98,94,85,35,
				60,25,85,29,66,25,38,22,77,54,85,100,65,30,7,8,49,66,38,79,4,99,49,63,63,69,82,43,38,83,11,56,85,25,38,61,40,36,67,84};
			//{1,1,1,1,1,1};
			//{1,2,3,4,5,6,7,8,9};
			//{1,1,1,1,1,1};
			//{1,2,3,4,5,6,7,8,9};
			//{2,2,1,1,5,3,3,5};
			//{1,2,3,4,5,6,7,8,9};
			//{4,4,5,5,6,7};
			//{1,2};
			//{ 2, 2, 1, 1, 5, 3, 3, 5 };
			//{1,1,1,2,2,2};
			//{10,2,8,9,3,8,1,5,2,3,7,6};
		// {1,1,1,2,2,2,3,3,3,4,4,4,5};
		// {10,2,8,9,3,8,1,5,2,3,7,6};

		// {1,1,1,2,2,2,3,3,3,4,4,4,5};
		// { 2, 2, 1, 1, 5, 3, 3, 5 };
		System.out.println(equalFrequency(nums));
	}

	private static int equalFrequency(int[] nums) {
		Map<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (mp.containsKey(nums[i])) {
				mp.put(nums[i], mp.get(nums[i]) + 1);

			} else {
				mp.put(nums[i], 1);
			}
		}

		Map<Integer, Long> resulter = mp.values().stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int min = resulter.values().stream().min(Long::compare).get().intValue();
		int max = resulter.values().stream().max(Long::compare).get().intValue();
		int val = 0;
		if (min == max) {
			max = mp.values().stream().min(Integer::compare).get().intValue();
			val=max;
		} else {

			for (Map.Entry<Integer, Long> entry : resulter.entrySet()) {
				if (entry.getValue() == max) {
					val = entry.getKey();
				}

			}
		}
		int idea = 0;
		int lent = 0;
	
		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			if (entry.getValue() == val) {
				lent = lent + val;
			} else if (entry.getValue()-1== val && idea<1) {
				idea ++;
				lent = lent+entry.getValue();
			}
		} 
		
		if(mp.size()==1) {
			for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
				if(entry.getKey()==1) {
					lent=lent-1;
				}
			}
			
		}
		if(resulter.size()==1) {
			for (Map.Entry<Integer, Long> entry : resulter.entrySet()) {
				if(entry.getKey()==1) {
					lent=lent-1;
				}
			}
			
		}
			if(lent==nums.length&&idea==0&&lent>2) {
				lent=lent-2;
			}
			if(lent==2&&idea==0) {
				lent=lent-1;
			}
		return idea > 0 ? lent : lent+1;

	}
}
