package com.Amazon;

import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectingRopes {
public static void main(String[] args) {
	int c[]= {8, 4, 6, 12};
	System.out.println(mergeFiles(c));
}
private static int mergeFiles(int[] files) {
	Queue<Integer> minHeap = new PriorityQueue<Integer>();
	for(int f : files) {
		minHeap.offer(f);
	}
	int res = 0;
	while(minHeap.size() > 1) {
		int f1 = minHeap.poll();
		int f2 = minHeap.poll();
		int tmp = f1 + f2;
		res += tmp;
		minHeap.offer(tmp);
	}
	return res;
}
}
