package com.leetcode;

import java.util.Arrays;

public class DistinctSubsequences {
	public static void main(String[] args) {
		DistinctSubsequences d = new DistinctSubsequences();
		String s="rabbbit";
		String t="rabbit";
		System.out.println(d.numDistinct(s, t));
	}
	
	    public int numDistinct(String s, String t) {
	        StringBuilder sb=new StringBuilder();
	      
	        String t1=t.toLowerCase();
	        int dp[][]=new int[s.length()][t.length()];
	        for(int arr[]:dp)Arrays.fill(arr,-1);
	        
	       return  helper(s.toLowerCase(),t1,0,0,sb,dp);
	       
	    }
	    
	    public int helper(String s, String t,int index,int j,StringBuilder sb,int dp[][]){
	            if(t.length()==sb.length()){
	                if(t.equals(sb.toString())){
	                  return 1;
	             }
	               
	                return 0;
	            }
	            
	            if(index>=s.length())return 0;
	            if(j>=t.length())return 0;
	           if(dp[index][j]!=-1) {
	        	   return dp[index][j];
	           }
	        int count=0;
	        for(int i=index;i<s.length();i++){
	            if(s.charAt(i)==t.charAt(j)){
	            	 sb.append(s.charAt(i));
	  	           count+= helper(s,t,i+1,j+1,sb,dp);
	  	            sb.deleteCharAt(sb.length()-1);
	            }
	           
	           
	        }
	        	dp[index][j]=count;
	            return count;
	    }
}
