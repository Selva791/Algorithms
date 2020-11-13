package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ErectTheFence {
	public static void main(String[] args) {
		ErectTheFence e=new ErectTheFence();
		int input[][]= {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
		e.outerTrees(input);
		
	}

	public int[][] outerTrees(int[][] points) {
		int n = points.length;
		int m = points[0].length;

		List<int[]> result = new ArrayList<>();

		int start[] = points[0];
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (start[0] > points[i][0]) {
				start = points[i];
				index = i;
			}
		}
		int []cur=start;
		result.add(start);
		List<int[]> collinear = new ArrayList<>();
		while (true) {
			int next[] = points[0];
			
			for (int i = 1; i < n; i++) {
				if(points[i]==start)continue;
				
				int val = crossProduct(start, next, points[i]);
				if (val > 0) {
					next = points[i];
					collinear = new ArrayList<>();
				} else if (val == 0) {
					if (distance(start, next, points[i]) < 0) {
						collinear.add(next);
						
						next=points[i];
					} else {
						collinear.add(points[i]);
						
					}
				}

			}
			result.addAll(collinear);
			if (cur== next) {
				break;
			}
			result.add(next);
			start=next;
			

		}
		int res[][]=new int[result.size()][2];
		System.out.println(result);
		for(int i=0;i<result.size();i++) {
			res[i]=result.get(i);
		}
		return res;
	}

	public int crossProduct(int start[], int b[], int c[]) {
		int s1 = start[0] - b[0];
		int s2 = start[1] - b[1];
		int s3 = start[0] - c[0];
		int s4 = start[1] - c[1];

		return s1*s4-s2*s3;

	}

	public int distance(int start[], int b[], int c[]) {
		int s1 = start[0] - b[0];
		int s2 = start[1] - b[1];
		int s3 = start[0] - c[0];
		int s4 = start[1] - c[1];
		int x = (s1 * s1) + (s2 * s2);
		int y = (s3 * s3) + (s4 * s4);
		return Integer.compare(x, y);
	}
}
