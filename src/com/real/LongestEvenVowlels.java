package com.real;

import java.util.HashMap;
import java.util.Map;

public class LongestEvenVowlels {
	
	public static void main(String[] args) {
		LongestEvenVowlels obj=new LongestEvenVowlels();
		System.out.println(obj.getLongestVowelSubString("aqwrteakjeaghevea"));
	    System.out.println(obj.getLongestVowelSubString("aea"));
	    System.out.println(obj.getLongestVowelSubString(""));
	    System.out.println(obj.getLongestVowelSubString("aaeaa"));
	    System.out.println(obj.getLongestVowelSubString("aae"));
	    System.out.println(obj.getLongestVowelSubString("pqrtpqrt"));
	}
	private String getLongestVowelSubString(String input) {
	    int left = input.length() - 1;
	    int right = 0;
	    Map<Character, Integer> count = new HashMap<>();
	    count.put('a', 0);
	    count.put('e', 0);
	    count.put('i', 0);
	    count.put('o', 0);
	    count.put('u', 0);

	    for (int i = 0; i < input.length(); i++) {
	      char ch = input.charAt(i);
	      if (count.containsKey(ch)) {
	        count.put(ch, count.get(ch) + 1);

	        if (count.get(ch) % 2 == 0) {
	          left = Math.min(left, input.indexOf(ch));
	          right = Math.max(right, input.lastIndexOf(ch));
	        }
	      }
	    }


	    if (left > right) {
	      return "";
	    }
	    return input.substring(left + 1, right);
	  }
}
