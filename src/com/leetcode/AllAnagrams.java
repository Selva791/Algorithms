package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllAnagrams {
public static void main(String[] args) {
	AllAnagrams a=new AllAnagrams();
	//"abacbabc"
	//"abc"
	System.out.println(a.findAnagrams("adcbaeabc","abc"));
	
}
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> value=new ArrayList<>();

	if(p.length()>s.length()) {
		return value;
	}
    int pl=p.length();
    int [] parr=new int[26];
    for(int i=0;i<pl;i++){
        int a=p.charAt(i)-'a';
        parr[a]++;
        
    }
    int left=0;
    int right=0;
    int count=pl;
    while(right<s.length()) {
    	if(parr[s.charAt(right)-'a'] >=1) {
    		parr[s.charAt(right)-'a']--;
    		right++;
    		count--;
    		
    	}else {
    		parr[s.charAt(right)-'a']--;
    		right++;
    		
    	}
    	if(count==0) {
    		value.add(left);
    	}
    	if((right-left)==pl) {
    		
    		if(parr[s.charAt(left)-'a']>=0) {
    			parr[s.charAt(left)-'a']++;
        		left++;
        		count++;
        		
        	}else {
        		parr[s.charAt(left)-'a']++;
        		left++;
        	}
    	}
    		
    	
    }
   
    return value;
}
}
