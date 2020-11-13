package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parantheses {
	public static void main(String[] args) {
		Parantheses p = new Parantheses();
		System.out.println(p.minRemoveToMakeValid("(a(b(c)d)"));
	}

	 public String minRemoveToMakeValid(String s) {
	     Stack<Integer> st=new Stack<>();
	        String str="";
	        for(int i=s.length()-1;i>=0;i--){
	            if(s.charAt(i)==')'){
	                st.push(i);
	                
	            }else{
	                if(s.charAt(i)=='('){
	                    if(!st.isEmpty()&&s.charAt(st.peek())==')'){
	                        st.pop();
	                        
	                    }else{
	                       st.push(i);

	                    }
	                }
	            }
	            
	        }      
	            if(!st.isEmpty()){
	                 for(int i=0;i<s.length();i++){
	                if(!st.isEmpty()&&i==st.peek()){
	                    st.pop();
	                }else{
	                str=str+s.charAt(i);
	                    }
	            } 
	            }else{
	             return s; 

	                
	            }
	          
	            
	        
	        
	       return str; 
	    }
}
