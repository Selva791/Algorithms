package com.Amazon;

import java.util.Arrays;

public class ConnectCities {
	public static void main(String[] args) {
		int N = 3;
		int connections[][] = { { 1, 2, 5 }, { 1, 3, 6 }, { 2, 3, 1 } };
		ConnectCities c = new ConnectCities();
		System.out.println(c.minimumCost(N, connections));
	}

	public int minimumCost(int N, int[][] connections) {
		Arrays.sort(connections, (a, b) -> a[2] - b[2]);

		int res = 0;
		UF uf = new UF(N);
		for (int[] connect : connections) {
			if (uf.find(connect[0]) != uf.find(connect[1])) {
				uf.union(connect[0], connect[1]);
				res += connect[2];
			}

			if (uf.count == 1) {
				return res;
			}
		}

		return -1;
	}
}

class UF {
	int[] parent;
	int[] size;
	int count;

	public UF(int n) {
		parent = new int[n + 1];
		size = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		this.count = n;
	}

	public int find(int i) {
		if (i != parent[i]) {
			parent[i] = find(parent[i]);
		}

		return parent[i];
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (size[i] > size[j]) {
			parent[j] = i;
			size[i] += size[j];
		} else {
			parent[i] = j;
			size[j] += size[i];
		}

		this.count--;
	}

}
