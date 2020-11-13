package com.leetcode;

import java.util.Arrays;

public class NextGreaterElementIII {
	public static void main(String[] args) {
		NextGreaterElementIII n=new NextGreaterElementIII();
		System.out.println(n.nextGreaterElement(1999999999));
	}
	 public int nextGreaterElement(int n) {
	       
	        String s=n+"";
	        int len=s.length();
	        
	        boolean flag=true;
	       char temp[]=s.toCharArray();
	       int i=0;
	      for(i=len-1;i>0;i--) {
	    	  
	    	  if(temp[i-1]<temp[i]) {
	    		  break;
	    	  }
	      }
	        
	      int start=temp[i-1];
	      int end=i;
	      for(int j=i+1;j<len;j++) {
	    	  if(temp[j]>start&&temp[j]<=temp[end]) {
	    		  end=j;
	    	  }
	    	  
	      }
	      char t=temp[end];
	      temp[end]=temp[i-1];
	      temp[i-1]=t;
	    Arrays.sort(temp,i,len);

	    String sp=new String(temp);
	        return Integer.valueOf(sp);
	    }

}
