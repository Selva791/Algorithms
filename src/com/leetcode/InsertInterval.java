package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	public static void main(String[] args) {
		InsertInterval in = new InsertInterval();
		int intervals[][] = { {1,5} };
		int newInterval[] = { 2,3};
		in.insert(intervals, newInterval);
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		;
		int n = intervals.length;
		if (n == 0)
			return new int[][] { newInterval };
		List<int[]> merge = new ArrayList<>();
		List<Integer> indices = new ArrayList<>();
		int result[][] = new int[n + 1][2];
		result[0] = newInterval;
		for (int i = 0; i < n; i++) {
			result[i + 1] = intervals[i];
		}

		Arrays.sort(result, (a, b) -> a[0] - b[0]);
		int temp[] = result[0];
	
		for (int i = 1; i < n + 1; i++) {
			if (temp[1] >= result[i][0] && temp[1] <= result[i][1]) {
				temp = new int[] { temp[0], result[i][1] };
				if(i==n)merge.add(temp);
			} else if (temp[1] < result[i][0]) {
				merge.add(temp);
				temp = result[i];
				if(i==n)merge.add(temp);

			}
		}
		
		int res[][] = new int[merge.size()][2];
		for (int i = 0; i < merge.size(); i++) {
			res[i] = merge.get(i);
		}
		Arrays.sort(res, (a, b) -> a[0] - b[0]);
		return res;

	}
}
