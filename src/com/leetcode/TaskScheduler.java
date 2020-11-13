package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
	public static void main(String[] args) {
		TaskScheduler t = new TaskScheduler();
		char task[] = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n=2;
		System.out.println(t.leastInterval(task, n));
		

	}

	public int leastInterval(char[] tasks, int n) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		Map<Character, Integer> mp = new HashMap<>();
		for (char c : tasks) {
			int t = mp.getOrDefault(c, 0);
			mp.put(c, t + 1);

		}
		pq.addAll(mp.values());
		int result = 0;
		while (!pq.isEmpty()) {
			int time=0;
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				if (!pq.isEmpty()) {
					list.add(pq.poll() - 1);
					time++;
				}

			}
			for (int tp : list)
				if (tp > 0)
					pq.add(tp);

			result+= pq.isEmpty() ? time : n+1;

		}
		return result;
	}
}
