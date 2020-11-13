package com.leetcode;

import java.util.Arrays;

import com.hacker.Reverse;

public class AddBinary {
	public static void main(String[] args) {
		AddBinary add=new AddBinary();
		System.out.println(add.addBinary("11","1"));
		int[] real= {1,3};
		Arrays.sort(real);
	}
	
	 public String addBinary(String a, String b) {
	       int n=a.length();
	       int m=b.length();
	        int i=n-1;
	        int j=m-1;
	        int sum=0;
	        int c=0;
	        StringBuilder sb=new StringBuilder();
	        while(i>=0||j>=0){
	            if(i>=0)sum+=a.charAt(i)-'0';
	            if(j>=0)sum+=b.charAt(j)-'0';
	            sum+=c;
	            sb.append(sum%2);
	            c=sum/2;
	            sum=0;
	            i--;
	            j--;
	                
	        }
	        if(c!=0)sb.append(c);
	        
	        return sb.reverse().toString();

	    }
}
