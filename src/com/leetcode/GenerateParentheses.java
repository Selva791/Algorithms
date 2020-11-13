package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses g=new GenerateParentheses();
		System.out.println(g.generateParenthesis(3));
	}
	    public List<String> generateParenthesis(int n) {
	        List<String> outPut=new ArrayList<String>();
	         parenthesis(n,"",0,0,outPut);
	         return outPut;
	    }
	    public void parenthesis(int max,String str,int open,int close, List<String> outPut){

	      if(str.length()==max*2) {
	    	  outPut.add(str);
	    	  return ;
	      }
	      if(open<max) {
	    	  parenthesis(max,str+"(",open+1,close,outPut);
	      }
	      if(close<open) {
	    	  parenthesis(max,str+")",open,close+1,outPut);

	      }
	    }
}
