package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms {
	public static void main(String[] args) {
		String f="H11He49NO35B7N46Li20";
		NumberOfAtoms n=new NumberOfAtoms();
		System.out.println(n.countOfAtoms(f));
	}

	public String countOfAtoms(String formula) {

		int n=formula.length();
	        Stack<String> st1=new Stack<>();
	        Stack<TreeMap> st2=new Stack<>();
	        Map<String,Integer> mp=new TreeMap<>();
	        for(int i=0;i<n;){
	            char c=formula.charAt(i);
	        
	             if(c=='('){
	             st2.push((TreeMap) mp);
	             mp=new TreeMap<>();	
	                i++;
	            }else if(c==')'){
	            	i++;
	              
	               int number=0;
	               while(i<formula.length()&&Character.isDigit(formula.charAt(i))) {
	            	   
	            	  number= number*10+formula.charAt(i++)-'0';
	               }
	               
	               if(!st2.isEmpty()) {
		               Map<String,Integer> temp=mp;
		               mp=st2.pop();

	            	   for(String s:temp.keySet()) {
		            	   int count=temp.get(s);
		            	   count=count*number;
		            	   mp.put(s,count+mp.getOrDefault(s,0));
		            	   
		               }
	               }
	            
	              
	                
	            }else {
	            	String sp=c+"";
	            	i++;
	            	while(i<formula.length()&&Character.isLowerCase(formula.charAt(i))) {
	            		sp=sp+formula.charAt(i);
	            		i++;
	            		c=formula.charAt(i);
	            	}
	            	
	            	int num=0;
	            	while(i<formula.length()&&Character.isDigit(formula.charAt(i))) {
		            		num=num*10+formula.charAt(i)-'0';
		            		i++;
	
	            		}
	            	
	            	num=num>0?num:1;
	            	mp.put(sp, mp.getOrDefault(sp, 0)+num);
	            		
	            	}
	            	
	            	
	            }
	        StringBuilder sb=new StringBuilder();
	        for(String k:mp.keySet()) {
	        	sb.append(k);
	        	if(mp.get(k)>1) {
		        	sb.append(mp.get(k));

	        	}
	        }
			return sb.toString();
	        
	    }

}
