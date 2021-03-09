package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {
	public static void main(String[] args) {
		String s="aewfafwafjlwajflwajflwafj";
		String str[]={"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"};
		List<String> d=Arrays.asList(str);
		LongestWordinDictionarythroughDeleting l=new LongestWordinDictionarythroughDeleting();
		l.findLongestWord(s, d);
				
	}

	public String findLongestWord(String s, List<String> d) {

		Collections.sort(d, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
		
		for (String str : d) {

			int i = 0, j = 0,count=0;
			while (j < s.length() && i < str.length()) {
				if (str.charAt(i) == s.charAt(j)) {
					i++;
					count++;
				}
				j++;
			}
			if (count == str.length())
				return str;

		}
		return "";
	}
}
