package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreakApproach {
	public static void main(String[] args) {
		WordBreakApproach wb=new WordBreakApproach();
		List<String> wordDict=new ArrayList<>();
		
		wordDict.add("aaaa");
		wordDict.add("aaa");
		//wordDict.add("applepen");
		//wordDict.add("pine");
		//wordDict.add("pineapple");
		wb.wordBreak("aaaaaaa", wordDict);
	}

	private void wordBreak(String string, List<String> wordDict) {
		// TODO Auto-generated method stub
		
		
	}
}
