package com.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
	public static void main(String[] args) {
		RepeatedDNASequences r=new RepeatedDNASequences();
		System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		
	}
	 public List<String> findRepeatedDnaSequences(String s) {
	        Map<String,Integer> mp=new HashMap<>();
	        List<String> result=new ArrayList<>();
	        int i=0;
	        StringBuilder sb=new StringBuilder(s);
	        while(i+10<s.length()){
	            sb=new StringBuilder(s.substring(i,i++ + 10));
	            mp.put(sb.toString(),mp.getOrDefault(sb.toString(),0)+1);
	            
	            if(mp.get(sb.toString())==2){
	                result.add(sb.toString());
	            }
	        }
	        return result;
	    }
}
