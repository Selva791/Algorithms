package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
	public static void main(String[] args) {
		WordSubsets w=new WordSubsets();
		String[]A= {"amazon","apple","facebook","google","leetcode"};
		String[]B= {"e","o"};
		System.out.println(w.wordSubsets(A, B));
	}

	public List<String> wordSubsets(String[] A, String[] B) {
		int[] alpha = new int[26];
		int n = B.length;
		List<String> ans = new ArrayList<>();
		for (String b : B) {
			int[] count = new int[26];
			for (int i = 0; i < b.length(); i++) {
				char c = b.charAt(i);
				count[c - 'a']++;
			}
			for (int j = 0; j < b.length(); j++) {
				alpha[b.charAt(j) - 'a'] = Math.max(alpha[b.charAt(j) - 'a'], count[b.charAt(j) - 'a']);
			}
		}

		for (String a : A) {
			int[] count = new int[26];
			for (int i = 0; i < a.length(); i++) {
				char c = a.charAt(i);
				count[c - 'a']++;
			}
			boolean flag = false;
			for (int j = 0; j < 26; j++) {
				
				if (alpha[j]>0&&alpha[j] > count[j]) {
					flag=true;
					break;
				}

			}
			if (!flag)
				ans.add(a);

		}
		return ans;
	}
}
