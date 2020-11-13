package com.leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {
		public static void main(String[] args) {
			RemoveDuplicateLetters r=new RemoveDuplicateLetters();
			String s="cbacdcbc";
			r.removeDuplicateLetters(s);
		}
		public String removeDuplicateLetters(String s) {
	        
	        int res[]=new int[26];
	        boolean flag[]=new boolean[26];
	        
	        char c[]=s.toCharArray();
	        for(char r:c){
	            res[r-'a']++;
	        }
	        Stack<Character> st=new Stack<>();
	        
	        for(char a:c){
	                
	        	res[a-'a']--;
	            while(!st.isEmpty()&&a<st.peek()&&res[st.peek()-'a']!=0){
	                st.pop();
	            }
	            st.push(a);
	            flag[a-'a']=true;
	        }
	        StringBuilder sb=new StringBuilder();
	        while(!st.isEmpty()){
	            sb.insert(0,st.pop());
	        }
	        return sb.toString();
	    }
}
