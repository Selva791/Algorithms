package com.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		Solution w=new Solution();
		List<String> wordList=new ArrayList<String>();
		String s1="hit";
		String s2="cog";
		//"hit"
		//"cog"
		//["hot","dot","dog","lot","log","cog"]
		//wordList.add("dot");
		wordList.add("dot");
		wordList.add("hot");
		wordList.add("dog");
		wordList.add("log");
		wordList.add("cog");
		wordList.add("lot");
		System.out.println(w.findLadders(s1, s2, wordList));
		
	}

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(beginWord));
        
        int level = 1, finalLevel = Integer.MAX_VALUE;
        List<String> words = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<String> list = queue.poll();
            
            if (list.size() > level) { // meaning: new word was added to list
                set.removeAll(words);
                words.clear();
                level = list.size();
               if (level > finalLevel) break;
            }
            
            String str = list.get(level - 1);
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == original) continue;
                    arr[i] = ch;
                    String newStr = String.valueOf(arr);

                    if (set.contains(newStr)) {
                        words.add(newStr);
                        List<String> newList = new ArrayList<>(list);
                        newList.add(newStr);
                        if (newStr.equals(endWord)) {
                            result.add(newList);
                            finalLevel = level;
                        } else {
                            queue.add(newList);
                        }
                    }
                }
                arr[i] = original;
            }
        }

        return result;
    }
}