package com.leetcode;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
	public static void main(String[] args) {
		FurthestBuildingYouCanReach f=new FurthestBuildingYouCanReach();
		int []heights= {4,12,2,7,3,18,20,3,19};
			int bricks=	10;
			int ladders=2;
		System.out.println(f.furthestBuilding(heights, bricks, ladders));
	}

	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		int n = heights.length;
		if (n <= ladders) {
			return n-1;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
		int s = heights[0], t = 0, ans = 0,small=0;
		
		for (int i = 1; i < n; i++) {
			int sum = 0, diff = 0;
			if (heights[i] > s) {
				diff = heights[i] - s;
				pq.add(diff);
				t += diff;
			}
			if (pq.size() > ladders) {
				small+=pq.poll();
				if(small<=bricks) {
					ans=i;
				}else {
					return ans;
				}
			}else {
				ans=i;
			}
			
			s = heights[i];
		}
		return ans;
	}
}
