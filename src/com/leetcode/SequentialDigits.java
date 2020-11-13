package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
	public static void main(String[] args) {
		SequentialDigits s=new SequentialDigits();
		System.out.println(s.sequentialDigits(100,300));
	}
	  List<Integer> result;
	    public List<Integer> sequentialDigits(int low, int high) {
	            result=new ArrayList<>();
	        String l=low+"";
	        String h=high+"";
	        int slen=l.length();
	        int hlen=h.length();
	        helper(low,high,l.charAt(0)-'0',h.charAt(0)-'0',slen,hlen,0);
	          return result;
	    }
	    public void helper(int low,int high,int start,int end,int slen,int hlen,int total){
	            if(total>=high||slen>hlen){
	                return ;
	            }
	       
	         total=0;
	        int s=start;
	        for(int i=0;i<slen&&slen<=hlen&&slen<=9;i++){
	            
	            if(s<10){
	              total=total*10+s;
	              s++;
	                
	            }else{
	                s=1;
	                start=s;
	                total=0;
	                slen=slen+1;
	                i=-1;
	            }
	            
	        }
	        if(slen>9||slen>hlen) {
	        	return;
	        }
	        if(total>high){
                return ;
            }
	        if(total==high) {
	        	result.add(total);
	        	return;
	        }
	        	
	        result.add(total);
	        helper(low,high,start+1,end,slen,hlen,total);
	        
	        
	    }

}
