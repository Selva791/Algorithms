package com.leetcode;

import java.util.Arrays;

public class ShortEncodingofWords {
	public static void main(String[] args) {
		ShortEncodingofWords s=new ShortEncodingofWords();
		System.out.println(s.minimumLengthEncoding(new String[] {"time", "me", "bell"}));
	}
	 public int minimumLengthEncoding(String[] words) {
	        Arrays.sort(words,(a,b)->new StringBuilder(a).reverse().toString()
	        		.compareTo(new StringBuilder(b).reverse().toString()));
	       StringBuilder sb=new StringBuilder();
	       int i=1;
	       boolean flag=false;
	       String str1="",str2="";
	       int p=0,q=0;
	        while(i<words.length) {
	        	if(!flag)
	        	  str1=words[i-1];
	        	
	        	  str2=words[i];
	        	 p=str1.length()-1;q=str2.length()-1;
	        	flag=false;
	        	while(p>=0&&q>=0) {
	        		if(str1.charAt(p)!=str2.charAt(q)) {
	        			sb.append(str1).append("#");
	        			break;
	        		}
	        		p--;
	        		q--;
	        	}
	        	if(p==-1) {       	   
	        	    flag=true;
	        	    str1=str2;
	        	}else if(q==-1) {
	        		flag=true;
	        		
	        	}
	        	i++;	
	        }
	        if(p==-1||q==-1) {
	        	sb.append(str1).append("#");
	        }else {
	        	sb.append(str2).append("#");
	        }
	        
	        
	        return sb.toString().length();
	    }
}
