package com.real;

import java.util.HashMap;
import java.util.Map;

public class EvenVowelsCount {
	public static void main(String[] args) {
		EvenVowelsCount ec=new EvenVowelsCount();
		
		System.out.println("Final : "+ec.findTheLongestSubstring("ambaa"));
	}
	    public int findTheLongestSubstring(String s) {
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, -1);
	        int best = 0, curr = 0;
	        for(int i = 0; i < s.length(); i++) {
	            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
	              || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
	                int diff = s.charAt(i) - 'a';
	                //System.out.println(60<<2);
	                
	               curr = diff;
	            }
	            map.putIfAbsent(curr, curr);
	          //  System.out.println(best);
	            best = Math.max(best, i - map.get(curr));
	            
	         //   System.out.println(i - map.get(curr));
	        }
	       // System.out.println(best);
	        return best;
	    }
}
