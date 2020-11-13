package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class WordLadderHard {
	public static void main(String[] args) {
		WordLadderHard w = new WordLadderHard();
		List<String> wordList = new ArrayList<String>();
		String s1 = "hit";
		String s2 = "cog";
		// "hit"
		// "cog"
		// ["hot","dot","dog","lot","log","cog"]
		// wordList.add("dot");
		wordList.add("dot");
		wordList.add("hot");
		wordList.add("dog");
		wordList.add("log");
		wordList.add("cog");
		wordList.add("lot");
		System.out.println(w.findLadders(s1, s2, wordList));

	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> s = new HashSet<>(wordList);
		List<List<String>> value =ladders(beginWord, endWord, s);

		return value;

	}

	public List<List<String>> ladders(String beginWord, String endWord, Set<String> wordList) {
		List<String> words = new ArrayList<>();
		Queue<List<String>> q = new LinkedList<>();
		List<List<String>> value = new ArrayList<>();
		q.add(Arrays.asList(beginWord));
		int level=1; int finalLevel=Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			
			List<String> p = q.poll();
			if(level<p.size()) {
				wordList.removeAll(words);
				words.clear();
                level = p.size();
                if (level > finalLevel) break;

				
			}
			String s=p.get(level-1);
			char c[]=s.toCharArray();
			
			for (int i = 0; i < c.length; i++) {
				char temp=c[i];

				for (char a ='a'; a <='z'; a++) {
					if(temp==a) continue;
					
					c[i]=a;
					String word=new String(c);
					if(wordList.contains(word)) {
						words.add(word);
						List<String> funt = new ArrayList<>(p);
						funt.add(word);
						
						if(word.equals(endWord)) {
							value.add(funt);
                           finalLevel = level;

							
						}else {
							q.add(funt);
						}
						
					}
					
					c[i]=temp;
	
						
					
					
				}
				
			}
		}

		return value;
	}
}

