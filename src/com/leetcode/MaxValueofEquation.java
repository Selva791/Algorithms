package com.leetcode;

import java.util.PriorityQueue;

public class MaxValueofEquation {
	public static void main(String[] args) {
		MaxValueofEquation m=new MaxValueofEquation();
		int pt[][]= {{-19,-12},{-13,-18},{-12,18},{-11,-8},{-8,2},{-7,12},{-5,16},{-3,9},{1,-7},{5,-4},{6,-20},{10,4},{16,4},{19,-9},{20,19}};
		int k=6;
		System.out.println(m.findMaxValueOfEquation(pt, k));
	}

	 public int findMaxValueOfEquation(int[][] points, int k) {
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]==b[0]?a[1]-b[0]:b[0]-a[0]));
	        int res = Integer.MIN_VALUE;
	        for (int[] point : points) {
	            while (!pq.isEmpty() && point[0] - pq.peek()[1] > k) {
	                pq.poll();
	            }
	            if (!pq.isEmpty()) {
	                res = Math.max(res, pq.peek()[0] + point[0] + point[1]);
	            }
	            pq.offer(new int[] {point[1] - point[0], point[0]});
	        }
	        return res;
	    }
}
