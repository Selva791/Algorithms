package com.leetcode;

public class FruitIntoBaskets {
	public static void main(String[] args) {
		FruitIntoBaskets f = new FruitIntoBaskets();
		int[] tree = {3,3,3,1,2,1,1,2,3,3,4};
		System.out.println(f.totalFruit(tree));
	}

	public int totalFruit(int[] tree) {
		int n = tree.length;
		int b1 = -1, b2 = -1;
		int t = 0, c1 = 0, count = 0;
		int max = 0;
		int i = 0, j = 0, k = 0;
		while (i < n) {

			if (b1 == tree[i]) {
				j = i;
				count++;
			} else if (b2 == tree[i]) {
				k = i;
				count++;
			} else if (b1 == -1) {
				b1 = tree[i];
				j = i;
				count++;
			} else if (b2 == -1) {
				b2 = tree[i];
				k = i;
				count++;
			} else {

				//System.out.println(count);
				max = Math.max(count, max);
				if (tree[i - 1] == b1) {
					b2 = tree[i];
					count = j - k;
					j=i-1; k=i;
					count++;
							
				} else if (tree[i - 1] == b2) {
					b1 = tree[i];
					count = k - j;
					k=i-1; j=i;
					count++;
				}

			}
			
			i++;
		}
		max = Math.max(count, max);
		return max;
	}
}
