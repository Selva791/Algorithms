package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CrackTheSafe {
	public static void main(String[] args) {
		CrackTheSafe c=new CrackTheSafe();
		System.out.println(c.crackSafe(2, 2));
	}
	   Set<String> st;
	    StringBuilder sb;
	    public String crackSafe(int n, int k) {
	        st=new HashSet<>();
	        sb=new StringBuilder("");
	        sherlock(n,k);
	        return sb.toString();
	    }
	    public void sherlock(int n,int k){
	       
	        for(int i=0;i<k;i++){
	            sb.append(i+"");
	             String s="";
	            if(sb.length()>=n)
	             s =sb.substring(sb.length()-n);
	           
	            if(sb.length()<n||!st.contains(s)){
	                 st.add(s);
	                 sherlock(n,k);
	            }else{
	                sb.deleteCharAt(sb.length()-1);
	            }
	           
	        }
	         
	         if(sb.length()>=n)
	          st.remove(sb.substring(sb.length()-n));
	         
	         sb.deleteCharAt(sb.length()-1);
	        
	    }
}
