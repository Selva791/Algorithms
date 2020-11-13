package com.leetcode;

public class AddStrings {
	public static void main(String[] args) {
		AddStrings a=new AddStrings();
		System.out.println(a.addStrings("2", "9"));
	}
	
	 public String addStrings(String num1, String num2) {
	        int n1=num1.length();
	        int n2=num2.length();
	        int n=0;
	        int count2=0;
	        int count1=0;
	        if(n1>n2){
	            n=n1;
	        }else n=n2;
	        StringBuilder sb=new StringBuilder();
	        int remain=0;
	        int sum=0;
	        for(int i=n1-1,j=n2-1;i>=0||j>=0;i--,j--){
	            if(i>=0)count1=(num1.charAt(i)-'0');
	            
	            if(j>=0)count2=(num2.charAt(j)-'0');
	            
	            
	            sum=(count1+count2+remain)%10;
	            remain=(count1+count2+remain)/10;
	            
	            sb.insert(0,(sum+""));
	             count1=0;
	             count2=0;
	        }
	       if(remain>0) sb.insert(0,(remain+""));
	        
	        return sb.toString();
	    }
}
