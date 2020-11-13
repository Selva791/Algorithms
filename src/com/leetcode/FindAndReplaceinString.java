package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceinString {
	public static void main(String[] args) {
		FindAndReplaceinString f = new FindAndReplaceinString();
		String S="vmokgggqzp";
		int indexes[]= {3,5,1};
		String sources[]= {"kg","ggq","mo"};
		String targets[]= {"s","so","bfr"};
		f.findReplaceString(S, indexes, sources, targets);
	}

	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		StringBuilder sb = new StringBuilder(S);
		int n = S.length();
		int prev = 0;
		int diff = 0;
		Map<Integer, String[]> mp = new HashMap<>();
		for (int i = 0; i < indexes.length; i++) {
			mp.put(indexes[i], new String[] { sources[i], targets[i] });
		}
		for (int i = 0; i < S.length(); i++) {
			String temp[] = mp.get(i);
			if (temp == null)
				continue;

			String src = temp[0];
			String r = temp[1];
			String tmp = S.substring(i, i + src.length());
			System.out.println(tmp);

			if (src.equals(tmp)) {
				sb.replace(i + diff, i + src.length() + diff, r);
				diff =diff+ r.length() - tmp.length();

			} else {
				sb.replace(i, i + src.length(), r);

			}
		}

		return sb.toString();
	}
}
