package com.leetcode;

public class InterleavingString {
	public static void main(String[] args) {
		InterleavingString s=new InterleavingString();
		String s1 = "aabcc";String s2 = "dbbca";String s3 = "aadbbcbcac";
		s.isInterleave(s1, s2, s3);
	}
	 public boolean isInterleave(String s1, String s2, String s3) {
	        StringBuilder sb=new StringBuilder();
	        return helper(s1,s2,s3,"",s1.length()+s2.length(),-1);
	        
	    }
	    public boolean helper(String s1, String s2, String s3,String sb,int n,int i){
         if(sb.length()>0&&sb.charAt(sb.length()-1)!=s3.charAt(i)){
             return false;
         }

	        if(sb.toString().equals(s3)&&sb.length()==n){
	            return true;
	        }
	        if(sb.length()>=s3.length()){
	            return false;
	        }
	       
	        if(s1.length()>0) {
	        	if(helper(s1.substring(1),s2,s3,sb+s1.charAt(0),n,i+1))return true;
	        }
	           if(s2.length()>0) {
	        	  if(helper(s1,s2.substring(1),s3,sb+s2.charAt(0),n,i+1))return true;
	           }
	            
	        

	        return false;
	    
	    }


}
