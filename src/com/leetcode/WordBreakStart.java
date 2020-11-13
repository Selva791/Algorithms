package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakStart {
    public static void main(String[] args) {
    	WordBreakStart w=new WordBreakStart();
    	String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    	List<String> set=new ArrayList<String>();
    	set.add("cats");
    	set.add("dog");
    	set.add("sand");
    	set.add("and");
    	set.add("cat");
    	System.out.println(w.wordBreak(s, set));
	}
    Set<String> cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        cache=new HashSet<>();
            return helper(s,set);
    }
    
    public boolean helper(String s,Set<String> set){
    		if(cache.contains(s)) {
    			return false;
    		}
            if(s.equals("")){
                return true;
            }
        System.out.println(s);
        for(int i=1;i<=s.length();i++){
                
            if(set.contains(s.substring(0,i))){
                System.out.println(s.substring(0,i));
               // System.out.println(s.substring(i));
                if(helper(s.substring(i),set))return true;
                
            }
        }
        cache.add(s);
        return false;
    }
}
