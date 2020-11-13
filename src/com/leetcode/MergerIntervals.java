package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergerIntervals {
	public static void main(String[] args) {
		int arr[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		// { { 1, 4 }, { 0, 2 }, { 3, 5 } };
		// {{1,3},{2,6},{8,10},{15,18}};
		// {{1,4},{4,5}};
		MergerIntervals m = new MergerIntervals();
		m.merge(arr);
	}

	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[][] {};
		}
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int n = intervals.length;
		List<int[]> check = new ArrayList<>();
		int result[][];
		int i = 0;
		int ar[] = intervals[i];
		while (i < n) {

				int sr[] = null;
			if ((i + 1) < n)
				sr = intervals[i + 1];

			if (sr != null && ar[1] >= sr[0]) {
				if (ar[1] > sr[1]) {
					i = i + 1;
				}

				else {
					ar[1] = sr[1];
					i = i + 1;
				}
			} else {
				check.add(ar);
				ar = sr;
				i++;
			}

		}
		int s = check.size();
		result = new int[s][2];
		for (int j = 0; j < s; j++) {
			result[j] = check.get(j);
		}

		return result;
	}
}
