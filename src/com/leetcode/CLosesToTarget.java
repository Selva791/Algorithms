package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CLosesToTarget {
	public static void main(String[] args) {
		int a[]= {9,12,3,7,15};
		CLosesToTarget c=new CLosesToTarget();
		c.closestToTarget(a, 5);
	}
	public int closestToTarget(int[] arr, int t) {
        int m = arr.length, res = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(arr[i]);
            for (int n : set) {
                tmp.add(n & arr[i]);
            }
            for (int n : tmp) res = Math.min(res, Math.abs(n - t));
            set = tmp;
        }
        return res;
    }
}
