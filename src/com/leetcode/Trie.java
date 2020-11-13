package com.leetcode;

import java.util.LinkedList;

public class Trie {
	public static void main(String[] args) {
		
		 //Your Trie object will be instantiated and called as such:
		Trie obj = new Trie();
		  obj.insert("hello");
		  boolean param_2 = obj.search("hell");
		  System.out.println(param_2);
		  boolean param_3 = obj.startsWith("hell");
		  System.out.println(param_3);

		 
	}
	    int size=26;
	    Trie dict[];
	    Trie root;
	    boolean end;
	    /** Initialize your data structure here. */
	    public Trie() {
	    	end=false;
	        dict=new Trie[size];
	        for(int i=0;i<size;i++){
	            dict[i]=null;
	            
	        }
	        
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	         Trie data=this;
	        for(int i=0;i<word.length();i++){
	           int c= word.charAt(i)-'a';
	            if(data.dict[c]==null){
	            	data.dict[c]=new Trie();
	            	data=data.dict[c];

	            }else{
	            	data=data.dict[c];
	            }
	            
	        }
	        data.end=true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	         Trie data=this;

	    	for (int i = 0; i < word.length(); i++) {
	    		int c=word.charAt(i)-'a';
	    		if(data.dict[c]!=null) {
	    			data=data.dict[c];
	    		}else {
	    			return false;
	    		}
	    		
				
			}
			return data.end;
	        
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	    	   Trie data=this;

		    	for (int i = 0; i < prefix.length(); i++) {
		    		int c=prefix.charAt(i)-'a';
		    		if(data.dict[c]!=null) {
		    			data=data.dict[c];
		    		}else {
		    			return false;
		    		}
		    		
					
				}
				return true;
	        
	    }
	}

	

