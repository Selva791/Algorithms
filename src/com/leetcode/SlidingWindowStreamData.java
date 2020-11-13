package com.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowStreamData {
	public static void main(String[] args) {
		int arr[]= {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
		int n=3;
		SlidingWindowStreamData s=new SlidingWindowStreamData();
		s.medianSlidingWindow(arr, n);
	}
   // PriorityQueue<Long> maxd=new PriorityQueue<>((a,b)->(long)b-(long)a);

	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

	public double[] medianSlidingWindow(int[] nums, int k) {
		int cache = 0;
		int n = nums.length;
		double median[] = new double[n - (k - 1)];

		int index = 0;
		boolean even = true;
		int i = 0;
		cache = nums[i];
		for (index = 0; index < k; index++) {

			max.offer(nums[index]);
			min.offer(max.poll());
			if (max.size() < min.size()) {
				max.offer(min.poll());
			}

		}

		median[i] = medianFinder();

		if (max.contains(cache)) {
			max.remove(cache);
			i += 1;
		} else {
			min.remove(cache);
			i += 1;
		}
		while (index < n) {
			cache = nums[i];

			max.offer(nums[index]);
			min.offer(max.poll());
			if (max.size() < min.size()) {
				max.offer(min.poll());

			}
		

			median[i] = medianFinder();
			index += 1;
			if (max.contains(cache)) {
				max.remove(cache);
				i += 1;
			} else {
				min.remove(cache);
				i += 1;
			}
		}
		return median;
	}

	public double medianFinder() {
		if (min.size() == max.size()) {
			return (double) ((long) min.peek() + (long) max.peek()) / 2;
		} else {
			return (double) max.peek();
		}
	}
}
