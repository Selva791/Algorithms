package com.leetcode;

import java.util.Stack;

//Remove K Digits
public class RemoveDigits {
	public static void main(String[] args) {
		RemoveDigits r=new RemoveDigits();
		String num = "112";
				int k = 1;
				String s1=Integer.valueOf("0300").toString();
		System.out.println(r.removeKdigits(num, k)+" "+s1);
		System.out.println(Integer.valueOf(s1));
	}
	 public String removeKdigits(String num, int k) {
	        if(num.length()<=k){
	            return "0";
	        }
	        int len=num.length();
	        int count=0;
	        Stack<Character> st=new Stack<>();
	       StringBuffer sb=new StringBuffer();
	       while(count<len) {
	    	   while(k>0&&!st.isEmpty()&&st.peek()>num.charAt(count)) {
	    		   st.pop();
	    		   k--;
	    		   
	    	   }
	    	   st.push(num.charAt(count));
	    	   count++;
	    	   
	       }
	       while(k>0) {
	    	   st.pop();
	    	   k--;
	       }
	       while(!st.isEmpty()) {
	    	   sb.append(st.pop());
	    	   
	       }
	       sb.reverse();
	        if(len==sb.length()) {
	        	sb.substring(k);
	        }
        int i = 0; 
        while (i < sb.length() && sb.charAt(i) == '0') 
            i++; 
        
        String d=sb.substring(i);
        
	        return d.isEmpty()?"0":d;
	    	    }
}
