package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {
	public static void main(String[] args) {
		JumpGameIII j = new JumpGameIII();
		int arr[] = { 3, 0, 2, 1, 2 };
		System.out.println(j.canReach(arr, 2));
	}

	public boolean isSafe(int n, int len) {
		if (n >= 0 && n < len) {
			return true;

		}
		return false;

	}

	public boolean canReach(int[] arr, int start) {
		int len = arr.length;
		Queue<Integer> q = new LinkedList<>();
		
		boolean visit[] = new boolean[len];
		q.add(start);

		while (!q.isEmpty()) {
			int s = q.poll();
			if (arr[s] == 0) {
				return true;
			}
				int x = s + arr[s];
				int y = s - arr[s];
				if (isSafe(x, len) && !visit[x]) {
					visit[x] = true;
					q.add(x);
				}
				if (isSafe(y, len) && !visit[y]) {
					visit[y] = true;
					q.add(y);

				}

				

		}
		return false;
	}

}
