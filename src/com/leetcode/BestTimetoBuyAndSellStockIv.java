package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BestTimetoBuyAndSellStockIv {
	public static void main(String[] args) {
		BestTimetoBuyAndSellStockIv b = new BestTimetoBuyAndSellStockIv();
		System.out.println(b.maxProfit(2, new int[] { 3, 2, 6, 5, 0, 3 }));
	}

	public int maxProfit(int k, int[] prices) {
		Map<String, Integer> dp = new HashMap<>();
		return helper(k, prices, dp, 0, 0);
		

	}
	public int helper(int k, int[] prices, Map<String, Integer> dp, int bought, int index) {
		if (k == 0)
			return 0;
		if (index >= prices.length) {
			return 0;
		}
		String key = bought + "" + index + "" + k;
		if (dp.containsKey(key)) {
			return dp.get(key);
		}
		int t = 0;
		t= helper(k, prices, dp, bought, index + 1);
		if (bought == 0) {
			int temp = helper(k, prices, dp, 1, index + 1) - prices[index];
			t = Math.max(t, temp);
		}
		else {
			int temp = helper(k-1, prices, dp, 0, index + 1) + prices[index];
			t = Math.max(t, temp);
		}

		dp.put(key, t);

		return t;
	}

}
