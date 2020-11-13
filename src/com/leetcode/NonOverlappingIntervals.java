package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class NonOverlappingIntervals {
	public static void main(String[] args) {
		int num[][] = {{1,100},{11,22},{1,11},{2,12}};
			//{ { 0, 1 }, { 3, 4 }, { 1,2 } };
		NonOverlappingIntervals n = new NonOverlappingIntervals();
		System.out.println(n.eraseOverlapIntervals(num));
	}

	public int eraseOverlapIntervals(int[][] intervals) {
		int n=intervals.length;
		if(n==0||n==1)return 0;
		Arrays.sort(intervals,(a,b)->a[1]-b[1]);
		List<int[]> res=new ArrayList<int[]>();
		int pr[]=intervals[0];
		res.add(pr);
		for(int i=1;i<intervals.length;i++) {
			int curr[]=intervals[i];
			if(pr[1]<=curr[0]) {
				res.add(curr);
				pr=curr;
				
			}
			
		}
		
		
		return n - res.size();	}
}
