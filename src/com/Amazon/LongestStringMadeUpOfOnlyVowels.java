package com.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringMadeUpOfOnlyVowels {
	public static void main(String[] args) {
		LongestStringMadeUpOfOnlyVowels lv=new LongestStringMadeUpOfOnlyVowels();
		//earthproblem
		//letsgosomewhere
		String s="earthproblem";
		 Map<Character,List<String>> set=new HashMap<>();
		set.computeIfAbsent('d', v-> new ArrayList<String>()).add("");
		System.out.println(lv.longestString(s));
	}
	public int longestString(String s){
		int n=s.length();
		int start=0;
		int end=s.length()-1;
		while(start<end&&isVowels(s.charAt(start))) {
			start++;
		}
		while(end>=0&&isVowels(s.charAt(end))) {
			end--;
		}
		if(start>=n) {
			return n;
		}
		int result=start+n-1-end;
		int longest=0;
		int sum=0;
		for(int i=start;i<end;i++) {
			if(isVowels(s.charAt(i))) {
				sum++;
				
			}else {
				sum=0;
			}
			longest=Math.max(sum,longest);
			
		}
		return result+longest;
	}
	
	private boolean isVowels(char c) {
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
			return true;
		}
		return false;
	}


}
