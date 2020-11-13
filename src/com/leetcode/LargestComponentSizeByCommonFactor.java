package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor {
	public static void main(String[] args) {
		LargestComponentSizeByCommonFactor l = new LargestComponentSizeByCommonFactor();
		int A[] = {99,100,69,39,14,56,91,60};
		System.out.println(l.largestComponentSize(A));
	}

	class UF {
		int[] parent;
		int[] size;
		int max;

		public UF(int N) {
			parent = new int[N];
			size = new int[N];
			max = 1;
			Arrays.fill(parent, -1);
		}

		public int find(int x) {
			if (parent[x] < 0) {
				return x;
			}
			return find(parent[x]);
		}

		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX != rootY) {;
		
					parent[rootY] += parent[rootX];
					parent[rootX] = rootY;
					
				

				
				max = Math.max(max, Math.abs(parent[rootY]));
			}
		}
	}

	public int largestComponentSize(int[] A) {
		int N = A.length;
		Map<Integer, Integer> map = new HashMap<>();// key is the factor, val is the node index
		UF uf = new UF(N);
		for (int i = 0; i < N; i++) {
			int a = A[i];
			for (int j = 2; j * j <= a; j++) {
				if (a % j == 0) {
					if (!map.containsKey(j)) {// this means that no index has claimed the factor yet
						map.put(j, i);
					} else {// this means that one index already claimed, so union that one with current
						uf.union(i, map.get(j));
					}
					if (!map.containsKey(a / j)) {
						map.put(a / j, i);
					} else {
						uf.union(i, map.get(a / j));
					}
				}
			}
			if (!map.containsKey(a)) {// a could be factor too. Don't miss this
				map.put(a, i);
			} else {
				uf.union(i, map.get(a));
			}
		}
		
		for(int i=0;i<N;i++) {
			//uf.max=Math.max(uf.max,Math.abs(uf.parent[i]));
		}
		return uf.max;
	}
}
