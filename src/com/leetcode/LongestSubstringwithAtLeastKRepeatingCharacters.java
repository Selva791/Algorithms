package com.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringwithAtLeastKRepeatingCharacters l=new LongestSubstringwithAtLeastKRepeatingCharacters();
		String s="bbaaacbd";
		int k=3;
		
		System.out.println(l.longestSubstring(s, k));
	}
	public int longestSubstring(String s, int k) {
        int n=s.length();
        int count=0;
        
        int hash[]=new int[26];
        Map<Character,Integer> mp=new HashMap<>();
        for(char c:s.toCharArray()){
            hash[c-'a']++;
        }
        int start=0;
        int max=0;
        boolean flag=false;
        char []arr=s.toCharArray();
        for(int i=0;i<n;i++){
            char d=arr[i];
            if(hash[d-'a']<k){
                max=Math.max(longestSubstring(s.substring(start,i),k),max);
                start=i+1;
                flag=true;
            }
            
            
        }
        if(flag==false) {
        	max=Math.max(max, s.length());
        }else {
        	max=Math.max(longestSubstring(s.substring(start),k),max);
        }
       return max; 
    }


}
