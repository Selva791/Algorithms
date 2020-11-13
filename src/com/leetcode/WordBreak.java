package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak {
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		List<String> wordDict = new ArrayList<>();

		// wordDict.add("aaaa");
		// wordDict.add("aaa");
		wordDict.add("cat");
		wordDict.add("cats");

		wordDict.add("sand");
		wordDict.add("dog");
		wordDict.add("and");

		//wordDict.add("pineapple");
		System.out.println(wb.wordBreak("catsanddog", wordDict));
	}

	// List<String> word = new ArrayList<>();
	// String last = "";
	public List<String> wordBreak(String s, List<String> wordDict) {
		
		Set<String> wordSet = new HashSet<>(wordDict);
		return wordBreak(s, new HashMap<>(), wordSet);
	}

	public List<String> wordBreak(String s, Map<String, List<String>> map, Set<String> wordDict) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> list = new ArrayList<>();
		if (wordDict.contains(s)) {
			list.add(s);
		}
		for (int i = 1; i < s.length(); i++) {
			String word = s.substring(i);
			if (wordDict.contains(word)) {
				List<String> prior = wordBreak(s.substring(0, i), map, wordDict);
				for (String s1 : prior) {
					list.add(s1 + " " + word);
				}
			}
		}
		map.put(s, list);
		return list;
	}
}
