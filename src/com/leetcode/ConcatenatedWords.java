package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
	public static void main(String[] args) {
		ConcatenatedWords c=new ConcatenatedWords();
		String words[]={"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		System.out.println(c.findAllConcatenatedWordsInADict(words));
	}
	 TrieNode node;
	    class TrieNode{
	        int size=26;
	        boolean isEnd=false;
	       TrieNode[]  trie=new TrieNode[size];
	        TrieNode(){
	            for(int i=0;i<26;i++){
	               trie[i]=null; 
	                
	            }
	        }
	    }
	    public List<String> findAllConcatenatedWordsInADict(String[] words) {
	            
	        dictationary(words);
	         List<String> result=new ArrayList<>();
	      
	        for(String r:words){
	        if(concate(r,0,node)){
	            result.add(r);
	        }
	 
	        }
	        return result;
	    }
	    public boolean concate(String word,int count,TrieNode root){
	    	if(word.equals("")) {
	    		return count>1;
	    	}
	        int n=word.length();
	       
	        TrieNode t=root;
	        for(int i=0;i<n;i++){
	            int a=word.charAt(i)-'a';
	            t=t.trie[a];
	          if(t==null)return false;
	          
	           if(t.isEnd){
	        	  if(concate(word.substring(i+1),count+1,root))return true;
	           }
	           
	            
	        }
			return count>1;
	        
	    }
	    public void dictationary(String[] words){
	        node=new TrieNode();
	        int n=words.length;
	        for(String w:words){
	        TrieNode temp=node;

	            for(int i=0;i<w.length();i++){
	               int a=w.charAt(i)-'a';
	               // temp=temp.trie[a];
	                if(temp.trie[a]==null){
	                    temp.trie[a]=new TrieNode();
	                    
	                    
	                }
	                temp=temp.trie[a];
	                
	            }
	            temp.isEnd=true;
	        }
	        
	    }

}
