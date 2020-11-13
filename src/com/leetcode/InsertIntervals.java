package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
	public static void main(String[] args) {
		InsertIntervals in = new InsertIntervals();
		// [[1,5]]
		// [2,7]
		int arr[][] = {{2,3},{5,5},{6,6},{6,7},{8,11}};
		//[[2,3],[5,5],[6,6],[7,7],[8,11]]
			//	[6,13]
			//{{1,2},{3,5},{6,7},{8,10},{12,16}};
			//{ { 1, 5 },{6,9},{8,11} };
		// {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int inter[] = { 6, 13 };
		// {4,8};

		in.insert(arr, inter);

	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		int n = intervals.length;
		 if(n==0) return new int[][]{newInterval};
		int[][] inter = new int[n + 1][2];
		inter[n]=newInterval;
		for(int i=0;i<=n;i++) {
			if(i<n)
			inter[i]=intervals[i];
			else {
				inter[i]=newInterval;
			}
			
		}
		Arrays.sort(inter,(a,b)->a[0]-b[0]);
		
		int j = 0;
		int a[] = inter[j];
		List<int[]> check = new ArrayList<>();
		while (j < n + 1) {
			int s[] = null;
			if ((j + 1) < n + 1)
				s = inter[j + 1];

			if (s != null && a[1] >= s[0]) {
				if (a[1] > s[1]) {
					j++;
				} else {
					a[1] = s[1];
					j++;

				}

			} else {
				check.add(a);
				a = s;
				j++;
			}

		}
		int m = check.size();
		int result[][] = new int[m][m];
		for (int p = 0; p < m; p++) {
			result[p] = check.get(p);

		}
		return result;
	}
}
