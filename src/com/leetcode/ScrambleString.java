package com.leetcode;

public class ScrambleString {
	public static void main(String[] args) {
		ScrambleString s = new ScrambleString();
		
		
		s.isScramble("dbdac","abcdd");
	}

	public boolean isScramble(String s1, String s2) {

		System.out.println(helper(s1, s2));
		return false;

	}

	public boolean helper(String s1, String s2) {

		if (s1.equals(s2)) {
			return true;
		}
			int arr1[]=new int[26];
			int arr2[]=new int[26];
		for(int i=0;i<s1.length();i++) {
			arr1[s1.charAt(i)-'a']++;
			arr2[s2.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++) {
			if(arr1[i]!=arr2[i]) {
				return false;
			}
		}
		for (int i = 1; i < s1.length(); i++) {
			if(helper(s1.substring(0, i), s2.substring(0,i))&&helper(s1.substring(i), s2.substring(i))){
				return true;
			}
			
			if(helper(s1.substring(0,i), s2.substring(s2.length()-i))&&helper(s1.substring(i), s2.substring(0,s2.length()-i))) {
				return true;
			}


		}

	
		return false;

	}
}
