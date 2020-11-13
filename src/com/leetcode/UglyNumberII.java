package com.leetcode;

public class UglyNumberII {
	public static void main(String[] args) {
		UglyNumberII ug=new UglyNumberII();
		System.out.println(ug.nthUglyNumber(10));
	}

	 public int nthUglyNumber(int n) {

	        int dp[]=new int[n+1];
	        dp[0]=1;
	        int i=0;
	        int j=0;
	        int k=0;
	        int h=1;
	       while(h<=n){
	           int a=dp[i]*2;
	           int b=dp[j]*3;
	           int c=dp[k]*5;
	           int r=Math.min(a,Math.min(b,c));
	           
	           dp[h++]=r;
	         
	            if(r==a){
	               i++;
	           }if(r==b){
	               j++;
	           }if(r==c){
	               k++;
	           }
	              
	       }
	       return dp[n-1];
	    }
}
