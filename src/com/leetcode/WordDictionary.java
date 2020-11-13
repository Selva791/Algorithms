package com.leetcode;

public class WordDictionary {
	public static void main(String[] args) {
		WordDictionary w=new WordDictionary();
		w.addWord("at");
		w.addWord("and");
		w.addWord("an");
		w.addWord("add");
		w.search("a");
		w.search(".at");
		w.addWord("bat");
		System.out.println(w.search(".at"));

		w.search("an.");
		w.search("a.d.");
		w.search("b.");
		w.search("a.d");
		w.search(".");

	}
	/** Initialize your data structure here. */
	int size = 26;
	WordDictionary[] word;
	boolean end = false;

	public WordDictionary() {
		word = new WordDictionary[size];
		for (int i = 0; i < size; i++) {
			word[i] = null;

		}
	}

	/** Adds a word into the data structure. */
	public void addWord(String words) {
		WordDictionary ws = this;
		for (char s : words.toCharArray()) {
			int a = s - 'a';

			if (ws.word[a] == null) {
				ws.word[a] = new WordDictionary();
			}
			ws = ws.word[a];

		}
		ws.end = true;

	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String words) {
		WordDictionary wp = this;

		return helper(words.toCharArray(), 0, wp);

	}

	public boolean helper(char temp[], int index, WordDictionary wp) {

		while (index < temp.length) {
			int t = temp[index] - 'a';

			if (temp[index] != '.' && wp.word[t] != null) {
				wp = wp.word[t];
				index += 1;
			} else if (temp[index] == '.') {
				

				index += 1;
				//
				for (int i = 0; i < 26; i++) {
					if (wp.word[i] != null) {

						if (helper(temp, index, wp.word[i])) {
							return true;
						}
					}
					
				}
				return false;
			} else if (wp.word[t] == null) {
				return false;
			}

		}
		if (wp.end)
			return true;
		else
			return false;
	}
}
