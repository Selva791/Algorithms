package com.leetcode;

import java.util.Arrays;

public class MostStonesRemovedWithSameRowOrColumn {
	public static void main(String[] args) {
		MostStonesRemovedWithSameRowOrColumn m=new MostStonesRemovedWithSameRowOrColumn();
		int[][]stones= {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		System.out.println(m.removeStones(stones));
	}

	public int removeStones(int[][] stones) {
		int n = stones.length;
		int[] parent = new int[n];
		Arrays.fill(parent, -1);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int f[] = stones[i];
				int s[] = stones[j];

				if (s[0] == f[0] || s[1] == f[1]) {
					int a=find(i,parent);
					int b=find(j,parent);
					if(a!=b)
					union(a, b, parent);
				}
			}
		}
		int c = 0;
		for (int a : parent) {
			if (a < 0)
				c++;

		}
		return n - c;
	}

	private int find(int i,  int[] parent) {
		if(parent[i]<0) {
			return i;
		}
		return find(parent[i], parent);
	}

	public void union(int i, int j, int[] parent) {

		if (i < j) {
			parent[i] +=parent[j];
			parent[j] = i;
		}else {
			parent[j] +=parent[i];
			parent[i] = j;
		}
	}	
}
