package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPoolingOwn {
	public static void main(String[] args) {
		CarPoolingOwn c=new CarPoolingOwn();
		int s[][]= {{8,2,3},{4,1,3},{1,3,6},{8,4,6},{4,4,8}};
		int capacity=12;
		System.out.println(c.carPooling(s, capacity));
	}

	public boolean carPooling(int[][] trips, int capacity) {
		int n = trips.length;
		Arrays.sort(trips, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

		int start[] = trips[0];
		int count = start[0];
		pq.add(trips[0]);
		for (int i = 1; i < n; i++) {
			int temp[] = trips[i];
			
				count += temp[0];
				

			 
			start = temp;
			while (!pq.isEmpty()) {
				int d[] = pq.peek();
				if (d[2] <= temp[1]) {
					count -= d[0];
					pq.poll();
				} else {
					break;
				}
			}
			pq.add(trips[i]);
			if (count > capacity)
				return false;

		}
		return true;
	}

}
