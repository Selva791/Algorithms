package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordPattern {
	public static void main(String[] args) {
		WordPattern w=new WordPattern();
		w.wordPattern("abba", "dog cat cat dog");
		
	}
	 public boolean wordPattern(String pattern, String str) {
	        Map<Character,List<Integer>> mp=new HashMap<>();
	        
	        for(int i=0;i<pattern.length();i++){
	           if(!mp.containsKey(pattern.charAt(i)))mp.put(pattern.charAt(i),new ArrayList<>());
	            mp.get(pattern.charAt(i)).add(i);
	        }
	        
	        String splited[]=str.split(" ");
	       Set<String> set=new HashSet<>();
	       String temp="";
	        for(char k:mp.keySet()){
	            List<Integer> index=mp.get(k);
	            
	            if(temp.equals(splited[index.get(0)]))return false;
	            
	             temp=splited[index.get(0)];
	            
	            if(!set.contains(temp))
	             set.add(temp);
	            else return false;
	            
	            for(int i=1;i<index.size();i++){
	                if(!temp.equals(splited[index.get(i)]))return false;
	                    
	               
	                
	            }
	            
	        }
	        return true;
	    }


}
