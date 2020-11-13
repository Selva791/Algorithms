package com.leetcode;

import java.util.Arrays;

public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber l = new LargestNumber();
		int nums[] = {824,968,1399,5607,6973,5703,9681,4398,8247};
		l.largestNumber(nums);

	}

	public String largestNumber(int[] nums) {
         int lent=nums.length;
       if(lent==0)return "";
       if(lent==1)return nums[0]+"";
     StringBuilder sb=new StringBuilder();
     String arr[]=new String[lent];
     for(int i=0;i<lent;i++){
         arr[i]=nums[i]+"";
         
     }
     Arrays.sort(arr,(a,b)->{
    	 //String t1=a+b;
    	 //String t2=b+a;
    	return a.compareTo(b);
         
     });
       
     int s='0';
     System.out.println(s);
        if(arr[0].charAt(0)=='0'){
            return '0'+"";
        }
     
    for(String st:arr){
        
             sb.append(st);
    }  
      
       
     return  sb.toString();
 }
}
