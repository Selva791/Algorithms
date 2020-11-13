package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//
public class EvenCountVowelsBitWiseOperator {
public static void main(String[] args) {
	EvenCountVowelsBitWiseOperator ec=new EvenCountVowelsBitWiseOperator();
	System.out.println("Final : "+ec.findTheLongestSubstring("leetcodeisgreat"));

}
HashSet<Character> vowels=new HashSet<>();
{
	vowels.add('a');
	vowels.add('e');
	vowels.add('i');
	vowels.add('o');
	vowels.add('u');

}
private int findTheLongestSubstring(String str) {
	Map<Integer, Integer> mp=new HashMap<>();
	// TODO Auto-generated method stub
	int bitmap=0;
	int longest=0;
	for (int i = 0; i < str.length(); i++) {
		char ch=str.charAt(i);
		if(vowels.contains(ch)) {
			bitmap=bitmap^(1<<(ch-'a'));
		}
		if(bitmap==0) {
			longest=i+1;
		}else {
			int index=mp.getOrDefault(bitmap,-1);
			if(index==-1) {
				mp.put(bitmap, i);
				
			}else {
			longest=Math.max(longest, i-index);
			}
			
			
		}
	}
	return longest;
}	
}
