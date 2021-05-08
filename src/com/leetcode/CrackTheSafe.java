package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CrackTheSafe {
	public static void main(String[] args) {
		CrackTheSafe c=new CrackTheSafe();
		System.out.println(c.crackSafe(3, 2));
	}
	   Set<String> st;
	    StringBuilder sb;
	    public String crackSafe(int n, int k) {
	        st=new HashSet<>();
	        sb=new StringBuilder("");
	        if(k==1) {
	        	for(int i=0;i<n;i++) {
	        		sb.append('0');
	        	}
	        	return sb.toString();
	        }
	        sherlock(n,k);
	        return sb.toString();
	    }
	    public boolean sherlock(int n,int k){
	    	int t=(int) Math.pow(k,n);
	    	if(t==st.size()) {
	    		return true;
	    	}
	        for(int i=0;i<k;i++){
	            sb.append(i+"");
	             String s="";
	            if(sb.length()>=n) {
	            	  s =sb.substring(sb.length()-n);
	            } 
	           
	            if(sb.length()<n||!st.contains(s)){
	            	if(!s.equals("")) {
	            		 st.add(s);
		                 if(sherlock(n,k))return true;
	            	}else {
	            		if(sherlock(n,k))return true;
	            	}
	            }else{
	                sb.deleteCharAt(sb.length()-1);
	            }
	           
	        }
	         
	         if(sb.length()>=n)
	          st.remove(sb.substring(sb.length()-n));
	         
	         sb.deleteCharAt(sb.length()-1);
	         
	         return false;
	        
	    }
}
