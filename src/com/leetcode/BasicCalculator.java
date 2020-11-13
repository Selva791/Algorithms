package com.leetcode;

import java.util.Stack;

public class BasicCalculator {
	public static void main(String[] args) {
		BasicCalculator b=new BasicCalculator();
		b.calculate("(1+(4+5+2)-3)+(6+8)");
	}

	public int calculate(String s) {
		 Stack<Integer> st=new Stack<>();
	        int number=0;
	        int sign=1;
	        int result=0;
	        for(int i=0;i<s.length();i++){
	            char c=s.charAt(i);
	            
	            if(Character.isDigit(c)){
	            	int g=c-'0';
	               number=number*10+ c-'0' ;
	                
	            }else if(c=='+'){
	                result+=sign*number;
	                sign=1;
	                number=0;
	                
	            }else if(c=='-'){
	                result+=sign*number;
	                sign=-1;
	                number=0;
	            }else if(c=='('){
	               
	                st.push(result);
	                st.push(sign);
	                result=0;
	                sign=1;
	                
	            }else if(c==')'){
	            	 result+=sign*number;
	                int d=st.pop();
	                int r=st.pop();
	                result*=d;
	                result+=r;
	               
	                number=0;
	            }
	           //
	        }  
	        result=result+sign*number;
	        return result;
	    
	}
}
