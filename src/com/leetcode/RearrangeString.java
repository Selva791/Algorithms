package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {
	public static void main(String[] args) {
		RearrangeString r = new RearrangeString();
		System.out.println(r.reorganizeString("aaabbbcc"));
	}
	
	//Easy to understand and Best optimal solution  --------------Master Piece Surprised....
	 public String reorganizeString(String S) {
	        int[] hash = new int[26];
	        for (int i = 0; i < S.length(); i++) {
	            hash[S.charAt(i) - 'a']++;
	        } 
	        int max = 0, letter = 0;
	        for (int i = 0; i < hash.length; i++) {
	            if (hash[i] > max) {
	                max = hash[i];
	                letter = i;
	            }
	        }
	        if (max > (S.length() + 1) / 2) {
	            return ""; 
	        }
	        char[] res = new char[S.length()];
	        int idx = 0;
	        while (hash[letter] > 0) {
	            res[idx] = (char) (letter + 'a');
	            idx += 2;
	            hash[letter]--;
	        }
	        for (int i = 0; i < hash.length; i++) {
	            while (hash[i] > 0) {
	                if (idx >= res.length) {
	                    idx = 1;
	                }
	                res[idx] = (char) (i + 'a');
	                idx += 2;
	                hash[i]--;
	            }
	        }
	        return String.valueOf(res);
	    }

	/*public String reorganizeString(String S) {
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		Map<Character, Integer> mp = new HashMap<>();
		int n = S.length();
		for (int i = 0; i < n; i++) {
			int c = mp.getOrDefault(S.charAt(i), 0);
			mp.put(S.charAt(i), c + 1);

		}
		StringBuilder sb = new StringBuilder();
		pq.addAll(mp.entrySet());
		int index=0;
		while (!mp.isEmpty()) {
			while (!pq.isEmpty()) {
				Map.Entry<Character, Integer> entry = pq.poll();
				char a = entry.getKey();
				int count = entry.getValue();
				if (count > 0) {
					index+=1;
					sb.append(a);
					int c = mp.get(a);
					mp.put(a, c - 1);
					if(index==2) {
						index=0;
						pq.clear();
						pq.addAll(mp.entrySet());
					}
				} else {
					mp.remove(a);
				}

			}
			if (mp.size() == 1) {
				for (char s : mp.keySet()) {
					if (mp.get(s) >0) {
						return "";
					}
				}
			}
			if (mp.size() > 0) {
				pq.addAll(mp.entrySet());
			}

		}

		return sb.toString();
	}*/
}
