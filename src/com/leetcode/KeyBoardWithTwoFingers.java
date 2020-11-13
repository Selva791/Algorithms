package com.leetcode;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/


public class KeyBoardWithTwoFingers {
	
	public static void main(String[] args) {
		String str = "QIBZR";
		KeyBoardWithTwoFingers k=new KeyBoardWithTwoFingers();
		System.out.println(k.minimumDistance(str));
	}

	class pair {
		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	Map<Character, pair> dpMap = new HashMap<>();

	public int minimumDistance(String word) {
		prepare();
		dp=new Integer[26][26][word.length()];;
		return helper('0', '0', 0, word, 0, 0);

	}

	Integer[][][] dp;

	public int helper(char f1, char f2, int index, String word, int i, int j) {
		if (index >= word.length()) {
			return 0;
		}
		//System.out.println(word.charAt(index));

		if (dp[i][j][index] != null) {
			return dp[i][j][index] ;
		}
		int m=distance(f1, word.charAt(index)) + helper(word.charAt(index), f2, index + 1, word, i, j + 1);
	System.out.println(m);
		int n=distance(f2, word.charAt(index)) + helper(f1, word.charAt(index), index + 1, word, i + 1, j);
	System.out.println(n);
		int value=Math.min(m,n);
		dp[i][j][index] =value;
//System.out.println(value);
		return dp[i][j][index];

	}

	public void prepare() {
		Character v = 'A';
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if (v <= 'Z') {
					dpMap.put(v, new pair(i, j));

				}
				v++;
			}

		}
	}

	public int distance(char s1, char s2) {
		System.out.println(s1+" "+s2);

		pair p1 = dpMap.get(s1);
		pair p2 = dpMap.get(s2);
		if(p1==null||p2==null)return 0;
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);

	}
}
