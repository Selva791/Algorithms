package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightDialer {
	public static void main(String[] args) {
		KnightDialer k=new KnightDialer();
		System.out.println(k.knightDialer(2));
	}

	Map<String, Integer> mp;
	final static int max = 1000000007;

	public int knightDialer(int N) {
		mp = new HashMap<>();
		int result = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				
				
				result = (result + helper(i, j, N, 0)) % max;
		       
		        
			}
		}
        
		return result;
	}

	public int helper(int i, int j, int n, int res) {
		if (i == 3 && j == 0)
			return 0;
		if (i == 3 && j == 2)
			return 0;
		 
		if (i >= 0 && j >= 0 && i < 4 && j < 3) {
			if (n == 1)
				return 1;

			String key = i + "_" + j + "_" + n;

			if (mp.containsKey(key))
				return mp.get(key);
			
			res += helper(i + 2, j + 1, n - 1, res) + helper(i + 2, j - 1, n - 1, res)
					+ helper(i + 1, j - 2, n - 1, res) + helper(i - 1, j - 2, n - 1, res)
					+ helper(i - 2, j - 1, n - 1, res) + helper(i - 2, j + 1, n - 1, res)
					+ helper(i - 1, j + 2, n - 1, res) + helper(i + 1, j + 2, n - 1, res);

			mp.put(key, res % max);
		}
		return res % max;
	}
}
