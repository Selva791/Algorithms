package com.leetcode;

public class StreamChecker {
	public static void main(String[] args) {
		StreamChecker s=new StreamChecker(new String[]{"aa","baa","baaa","aaa","bbbb"});
		System.out.println(s.query('b'));
		System.out.println(s.query('b'));
		System.out.println(s.query('b'));
		s.query('a');
		s.query('b');
		s.query('l');
        StringBuilder sb=new StringBuilder();

	}
	   Trie start;
	    class Trie{
	       Trie dict[];

	        int size=26;
	        boolean flag=false;
	        Trie(){
	           dict=new Trie[26];
	          for(int i=0;i<size;i++){
	              dict[i]=null;
	          }  
	        }
	    }
	   
	    public StreamChecker(String[] words) {
          // if(words)
	         start=new Trie();
	        
	        for(String w:words){
	        	Trie temp=start;
	            for(int i=w.length()-1;i>=0;i--){
	                int a=w.charAt(i)-'a';
	                if(temp.dict[a]==null){
	                    temp.dict[a]=new Trie();
	                }
	                temp=temp.dict[a];
	            }
	            temp.flag=true;
	        }
	        query=start;
	    }
	    Trie query;
       StringBuilder sb = new StringBuilder();

	    public boolean query(char letter) {
	    	
           sb.append(letter);
           query=start;
           for(int i=sb.length()-1;i>=0;i--){
               char w=sb.charAt(i);
            if(query.dict[w-'a']!=null){
	            query=query.dict[w-'a'];
	            if(query.flag==true){
	                 
	                return true;
	            }
	            
	            
	        }else {
	            query=start;
	            return false;
	        }
           }
	       return false;
	        
	    }
	}

