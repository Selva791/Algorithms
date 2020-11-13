package com.leetcode;

public class ProductOfArrayExceptSelf {
public static void main(String[] args) {
	ProductOfArrayExceptSelf p=new ProductOfArrayExceptSelf();
	int n[] ={1,2,3,4};
//	char s=(char)2+'a';
	//System.out.println(s);
	System.out.println(p.productExceptSelf(n));
}
public int[] productExceptSelf(int[] nums) {
	int n=nums.length;
	int temp[]=new int[n];
	temp[0]=1;
    for(int i=1;i<n;i++){
    	  temp[i]=temp[i-1]*nums[i-1];   
      
  }
    int r=1;
  for(int i=nums.length-1;i>=0;i--){
	  temp[i]=temp[i]*r;
	  r*=nums[i];
      
      
  }
return temp;
  
}
}
